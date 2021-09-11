package Pattern;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import Editor.Canvas;

public class AssociationLine extends BasicLine {
	private JComponent lineInstance;

	public AssociationLine(Canvas canvas, int firstX, int firstY, int secondX, int secondY, BasicObject firstComponent,
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
				g2.draw(new Line2D.Double(firstConnectPoint.x, firstConnectPoint.y, 
						secondConnectPoint.x, secondConnectPoint.y));
			}			
		};
		canvas.add(lineInstance, new Integer(1));
		paintObj(canvas);
	}

	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		super.paintObj(canvas);
		lineInstance.setBounds(0, 0, canvasWidth, canvasHeight);
		canvas.repaint();
	}
	

}
