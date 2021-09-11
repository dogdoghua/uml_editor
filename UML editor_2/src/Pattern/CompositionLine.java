package Pattern;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import Editor.Canvas;

public class CompositionLine extends BasicLine{
    
	private int[] compos_dimandx = { 5, 10, 5, 0 };  // x coordinates of composition line shape
    private int[] compos_dimandy = { 0, 5, 10, 5 };  // y coordinates of composition line shape
    private int[] xOffsetOfShape = { -5, 5, -5, -15 };
    private int[] yOffsetOfShape = { -15, -5, 5, -5 };
    private JComponent lineInstance, composLineTypeShape;
    
    public CompositionLine(Canvas canvas, int firstX, int firstY, int secondX, int secondY, BasicObject firstComponent,
			BasicObject secondComponent) {
		super(canvas, firstX, firstY, secondX, secondY, firstComponent, secondComponent);
		// TODO Auto-generated constructor stub
		
		lineInstance = new JComponent() {

			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(1.5f));
				g2.setColor(Color.black);
				g2.draw(new Line2D.Double(adjustedFirstConnectPoint.x + 5, adjustedFirstConnectPoint.y + 5,
                        secondConnectPoint.x, secondConnectPoint.y));
			}
		};
		
		canvas.add(lineInstance, new Integer(0));
		
		composLineTypeShape = new JComponent() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.white);
                g2.fillPolygon(compos_dimandx, compos_dimandy, 4);
                g2.setStroke(new BasicStroke(2f));
                g2.setColor(Color.black);
                g2.drawPolygon(compos_dimandx, compos_dimandy, 4);
            }
        };
        canvas.add(composLineTypeShape, new Integer(1));
        paintObj(canvas);
        
        
    }

	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		super.paintObj(canvas);
		adjustedFirstConnectPoint.setLocation(firstConnectPoint.x + xOffsetOfShape[firstChosenPortIndex],
                firstConnectPoint.y + yOffsetOfShape[firstChosenPortIndex]);
        composLineTypeShape.setBounds(adjustedFirstConnectPoint.x, adjustedFirstConnectPoint.y, 10, 10);
        lineInstance.setBounds(0, 0, canvasWidth, canvasHeight);
        
        canvas.repaint();
	}

    
    

}
