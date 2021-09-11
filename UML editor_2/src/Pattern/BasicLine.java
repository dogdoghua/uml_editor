package Pattern;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

import Editor.Canvas;
import Editor.EditorFrame;

public class BasicLine extends Pattern{

	protected int firstChosenPortIndex, secondChosenPortIndex;
	protected BasicObject firstComponent, secondComponent;
	protected Point firstConnectPoint = new Point();
	protected Point secondConnectPoint = new Point();
	protected Point adjustedFirstConnectPoint = new Point();
	protected int canvasWidth, canvasHeight;
	private JLabel firstConnectPort, secondConnectPort;
	
	public BasicLine(Canvas canvas, int firstX, int firstY, int secondX, int secondY, 
			BasicObject firstComponent, BasicObject secondComponent) {
		firstChosenPortIndex = calClosestPort(firstX, firstY, firstComponent);
		secondChosenPortIndex = calClosestPort(secondX, secondY, secondComponent);
		this.firstComponent = firstComponent;
		this.secondComponent = secondComponent;
		
		firstConnectPort = new JLabel();
		firstConnectPort.setOpaque(true);
		firstConnectPort.setBackground(Color.black);
		canvas.add(firstConnectPort, new Integer(1));
		
		secondConnectPort = new JLabel();
		secondConnectPort.setOpaque(true);
		secondConnectPort.setBackground(Color.black);
		canvas.add(secondConnectPort, new Integer(1));
		
	}
	
	
	
	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		firstConnectPoint = getPortCoord(firstComponent, firstChosenPortIndex);
		secondConnectPoint = getPortCoord(secondComponent, secondChosenPortIndex);
		firstConnectPort.setBounds(firstConnectPoint.x - 5, firstConnectPoint.y - 5, 10, 10);
		secondConnectPort.setBounds(secondConnectPoint.x - 5, secondConnectPoint.y - 5, 10, 10);
		canvasWidth = 200 + 20 + (70+20) * EditorFrame.getSideBtnNumber();
		canvasHeight = 20 + (70+20) * EditorFrame.getSideBtnNumber();
	}



	private int calClosestPort(int x, int y, BasicObject c) {
		int[] xcoord = {c.xmin + (c.xmax - c.xmin) / 2, c.xmax, c.xmin + (c.xmax - c.xmin) / 2, c.xmin};
		int[] ycoord = {c.ymin, c.ymin + (c.ymax - c.ymin) / 2, c.ymax, c.ymin + (c.ymax - c.ymin) / 2};
		int minIndex =0;
		double min = 10000;
		for(int i=0; i<4; i++) {
			double dist = Math.sqrt(Math.pow(x-xcoord[i], 2) + Math.pow(y-ycoord[i], 2));
			if(dist < min) {
				min = dist;
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private Point getPortCoord(BasicObject c, int portIndex) {
		int[] xcoord = {c.xmin + (c.xmax - c.xmin) / 2, c.xmax, c.xmin + (c.xmax - c.xmin) / 2, c.xmin};
		int[] ycoord = {c.ymin, c.ymin + (c.ymax - c.ymin) / 2, c.ymax, c.ymin + (c.ymax - c.ymin) / 2};
		return new Point(xcoord[portIndex], ycoord[portIndex]);
	}
	
}
