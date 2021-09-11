package Pattern;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import Editor.Canvas;

public class GenerationLine extends BasicLine{
	private int[][] gene_trianglex = { { 0, 10, 5 },  // x coordinates of composition line shape
	        { 0, 10, 10 },
	        { 5, 10, 0 },
	        { 0, 10, 0 } };
	private int[][] gene_triangley = { { 0, 0, 10 },  // y coordinates of composition line shape
	        { 5, 0, 10 },
	        { 0, 10, 10 },
	        { 0, 5, 10 } };
	
	private int[] xOffsetOfShape = { -5, 5, -5, -15 };
    private int[] yOffsetOfShape = { -15, -5, 5, -5 };
    private JComponent lineInstance, geneLineTypeShape;
    
	public GenerationLine(Canvas canvas, int firstX, int firstY, int secondX, int secondY, BasicObject firstComponent,
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
                // adjusting the connecting point of generation lines and composition lines
                g2.draw(new Line2D.Double(adjustedFirstConnectPoint.x + 5, adjustedFirstConnectPoint.y + 5,
                        secondConnectPoint.x, secondConnectPoint.y));
			}			
		};
		canvas.add(geneLineTypeShape, new Integer(1));
		paintObj(canvas);
	}

	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		super.paintObj(canvas);
		adjustedFirstConnectPoint.setLocation(firstConnectPoint.x + xOffsetOfShape[firstChosenPortIndex],
                firstConnectPoint.y + yOffsetOfShape[firstChosenPortIndex]);
        geneLineTypeShape.setBounds(adjustedFirstConnectPoint.x, adjustedFirstConnectPoint.y, 10, 10);
        lineInstance.setBounds(0, 0, canvasWidth, canvasHeight);
        
        canvas.repaint();
	}
	
	

}
