package Editor;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

import Mode.BasicMode;
import Pattern.BasicLine;
import Pattern.BasicObject;
import Pattern.GroupObj;

public class Canvas extends JLayeredPane {
	public static BasicMode currentMode = null;
    public ArrayList<BasicObject> objectComponents = new ArrayList<BasicObject>();  // all objects on the canvas
    public ArrayList<BasicLine> lineComponents = new ArrayList<BasicLine>();  
    public ArrayList<BasicObject> selectedGroupComponents = new ArrayList<BasicObject>();  // saves the objects selected by block selection
    public BasicObject selectedObj;
    
	
	private BasicObject pressedObj, releasedObj;
	private int x_mousePress, y_mousePress, x_mouseRelease, y_mouseRelease;
	
	
	public Canvas() {
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if(currentMode == null)
					return;
				pressAction(e.getX(), e.getY());
			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(currentMode == null)
					return;
				releaseAction(e.getX(), e.getY());
			}			
		});
		
	}
	
	private void pressAction(int x, int y) {
		x_mousePress = x;
		y_mousePress = y;
		pressedObj = checkIfOnComponent(x, y);
		
	}
	
	private void releaseAction(int x, int y) {
		x_mouseRelease = x;
		y_mouseRelease = y;
		hideAllPorts();
		EditorFrame.setEditMenuUnGroup(false);
		EditorFrame.setEditMenuChangeName(false);
		
		releasedObj = checkIfOnComponent(x, y);
		currentMode.releaseAction(this, pressedObj, releasedObj, x_mousePress, y_mousePress, x_mouseRelease, y_mouseRelease);
	}

	
	private BasicObject checkIfOnComponent(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < objectComponents.size(); i++) {
            if (objectComponents.get(i).checkIfOnComponent(x, y))
                return objectComponents.get(i);
        }
		return null;
	}
	
	public void setGroupComponents() {
		BasicObject groupObj = new GroupObj(selectedGroupComponents);
		objectComponents.add(0, groupObj);
	}
	public void rmGroupComponents() {
		for(int i=0; i<objectComponents.size(); i++) {
			if(objectComponents.get(i).equals(selectedObj))
				objectComponents.remove(i);
		}
	}
	
	public void hideAllPorts() {
		EditorFrame.setEditMenuGroup(false);
		if(selectedObj != null)
			selectedObj.hidePorts(this);
		// unselected
		for(int i=0; i<selectedGroupComponents.size(); i++)
			selectedGroupComponents.get(i).hidePorts(this);
		selectedGroupComponents.clear();
	}
	
	public void switchTopComponentToArrayListHead(BasicObject obj) {
		for(int i=0;  i<objectComponents.size(); i++) {
			if(objectComponents.get(i).equals(obj)) {
				objectComponents.remove(i);
				objectComponents.add(0, obj);
			}
		}
	}

}
