package Pattern;

import java.util.ArrayList;

import Editor.Canvas;
import Editor.EditorFrame;

public class GroupObj extends BasicObject{
	private ArrayList<BasicObject> groupList;
	
	public GroupObj(ArrayList<BasicObject> objOfGroup) {
		groupList = (ArrayList<BasicObject>) objOfGroup.clone();
	}

	@Override
	public void showPorts(Canvas canvas) {
		// TODO Auto-generated method stub
	}

	@Override
	public void hidePorts(Canvas canvas) {
		// TODO Auto-generated method stub
		for(int i=0; i<groupList.size(); i++) {
			groupList.get(i).hidePorts(canvas);
		}
	}

	@Override
	public void select(Canvas canvas) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<groupList.size(); i++) {
			groupList.get(i).moveComponentFront(canvas);
			groupList.get(i).showPorts(canvas);
		}
		
	}

	@Override
	public void move(Canvas canvas, int xmove, int ymove) {
		// TODO Auto-generated method stub
		for(int i=0; i<groupList.size(); i++) {
			groupList.get(i).move(canvas, xmove, ymove);
		}
	}

	@Override
	public boolean checkIfOnComponent(int x, int y) {
		// TODO Auto-generated method stub
		for(int i=0; i<groupList.size(); i++) {
			if(groupList.get(i).checkIfOnComponent(x, y))
				return true;
		}
		return false;
	}

	@Override
	public void paintObj(Canvas canvas) {
		// TODO Auto-generated method stub
		for(int i=0; i<groupList.size(); i++) {
			groupList.get(i).paintObj(canvas);
		}
	}
	
	
	
	
}
