package Pattern;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

import Editor.Canvas;
import Editor.EditorFrame;

public class UseCaseObj extends BasicObject{

	private JComponent oval = new JComponent() {

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillOval(0, 0, 110, 50);
			g2.setStroke(new BasicStroke(1.5f));
			g2.setColor(Color.black);
			g2.drawOval(0, 0, 110, 50);
		}		
	};
	private JLabel ovalName = new JLabel();
	
	public UseCaseObj(Canvas canvas, int x, int y) {
		super.xmin = x;
		super.ymin = y;
		super.xmax = x + 110;
		super.ymax = y + 50;
		
		oval.setBounds(x, y, 110, 50);
		ovalName.setBounds(x, y, 110, 50);
		
		canvas.add(oval, new Integer(0));
		canvas.add(ovalName, new Integer(0));
		paintObj(canvas);
	}

	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		oval.setBounds(super.xmin, super.ymin, 110, 50);
		ovalName.setBounds(super.xmin, super.ymin, 110, 50);
		canvas.repaint();
	}

	@Override
	public void select(Canvas canvas) {
		// TODO Auto-generated method stub
		EditorFrame.setEditMenuChangeName(true);
		moveComponentFront(canvas);
		canvas.switchTopComponentToArrayListHead(this);
		showPorts(canvas);
	}

	@Override
	public void moveComponentFront(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.moveToFront(oval);
		canvas.moveToFront(ovalName);
	}

	@Override
	public void changeName(String name) {
		// TODO Auto-generated method stub
		ovalName.setFont(new Font(null, 0, 15));
		ovalName.setText(name);
		ovalName.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public boolean checkIfOnComponent(int x, int y) {
		// TODO Auto-generated method stub
		if(x>=this.xmin && x<=this.xmax &&
				y>=this.ymin && y<=this.ymax)
			return true;
		return false;
	}
	
	
}
