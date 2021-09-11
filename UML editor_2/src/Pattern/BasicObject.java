package Pattern;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

import Editor.Canvas;

public class BasicObject extends Pattern {
	protected ArrayList<JLabel> portList = new ArrayList<JLabel>();
	
	public void showPorts(Canvas canvas) {
		
		int[] xoffset = { (super.xmax - super.xmin) / 2 - 5,
	            (super.xmax - super.xmin) - 5,
	            (super.xmax - super.xmin) / 2 - 5,
	            -5 };
		int[] yoffset = { -5,
	            (super.ymax - super.ymin) / 2 - 5,
	            (super.ymax - super.ymin) - 5,
	            (super.ymax - super.ymin) / 2 - 5 };
		
		for(int i=0; i<4; i++) {
			JLabel tmpPort = new JLabel();
			tmpPort.setBounds(super.xmin + xoffset[i], super.ymin + yoffset[i], 10, 10);
			tmpPort.setOpaque(true);
			tmpPort.setBackground(Color.black);
			portList.add(tmpPort);
			canvas.add(tmpPort, new Integer(2));
		}
		canvas.repaint();

  	}
	
	public void hidePorts(Canvas canvas) {
        for (int i = 0; i < this.portList.size(); i++)
            canvas.remove(this.portList.get(i));
        canvas.repaint();
        portList.clear();
	}
	
    public void select(Canvas canvas) {

    }

    public void move(Canvas canvas, int xmove, int ymove) {
        this.xmax += xmove;
        this.xmin += xmove;
        this.ymax += ymove;
        this.ymin += ymove;
    }

    public void moveComponentFront(Canvas canvas) {

    }

    public void changeName(String name) {

    }

    public boolean checkIfOnComponent(int x, int y) {
        return false;
    }
}
