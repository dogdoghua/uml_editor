package Pattern;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Editor.Canvas;
import Editor.EditorFrame;

public class ClassObj extends BasicObject{
	private ArrayList<JLabel> classLabel = new ArrayList<JLabel>(3);
	
	public ClassObj(Canvas canvas, int x, int y) {
		super.xmin = x;
		super.ymin = y;
		super.xmax = x + 100;
		super.ymax = y + 3*40;
		
		for(int i=0; i<3; i++) {
			JLabel tmpLabel = new JLabel();
			tmpLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			tmpLabel.setOpaque(true);
			tmpLabel.setBackground(Color.white);
			classLabel.add(tmpLabel);
			canvas.add(tmpLabel, new Integer(0));
		}
		paintObj(canvas);
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
		for(int i=0; i<3; i++) {
			canvas.moveToFront(classLabel.get(i));
		}
	}

	@Override
	public void changeName(String name) {
		// TODO Auto-generated method stub
		classLabel.get(0).setFont(new Font(null, 0, 15));
		classLabel.get(0).setText(name);
		classLabel.get(0).setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public boolean checkIfOnComponent(int x, int y) {
		// TODO Auto-generated method stub
		if(x>=this.xmin && x<=this.xmax &&
				y>=this.ymin && y<=this.ymax)
			return true;
		return false;
	}

	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		for(int i=0; i<3; i++) {
			classLabel.get(i).setBounds(super.xmin, super.ymin+i*40, 100, 40);
		}
		moveComponentFront(canvas);
		canvas.repaint();
	}
	
}
