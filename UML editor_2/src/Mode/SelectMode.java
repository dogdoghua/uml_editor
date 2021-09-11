package Mode;

import Editor.Canvas;
import Editor.EditorFrame;
import Pattern.BasicObject;

public class SelectMode extends BasicMode{

	@Override
	public void clickAction(Canvas canvas, BasicObject currentClickObj, int x, int y) {
		// TODO Auto-generated method stub
		canvas.hideAllPorts();
		
		if(currentClickObj == null)
			return;
		
		currentClickObj.select(canvas);
	}

	@Override
	public void releaseAction(Canvas canvas, BasicObject pressObj, BasicObject releaseObj, int pressX, int pressY,
			int releaseX, int releaseY) {
		// TODO Auto-generated method stub
		if(pressObj == null) {
			canvas.hideAllPorts();
			
			if (pressX > releaseX) {
                int tmp = releaseX;
                releaseX = pressX;
                pressX = tmp;
            }
            if (pressY > releaseY) {
                int tmp = releaseY;
                releaseY = pressY;
                pressY = tmp;
            }
            for (int i = 0; i < canvas.objectComponents.size(); i++) {
                if (pressX <= canvas.objectComponents.get(i).xmin &&
                        pressY <= canvas.objectComponents.get(i).ymin &&
                        releaseX >= canvas.objectComponents.get(i).xmax &&
                        releaseY >= canvas.objectComponents.get(i).ymax) {
                    canvas.objectComponents.get(i).showPorts(canvas);
                    canvas.selectedGroupComponents.add(canvas.objectComponents.get(i));  // add candidate grouping objects
                    EditorFrame.setEditMenuGroup(true);
                }
            }
            if (canvas.selectedGroupComponents.size() == 1)
                EditorFrame.setEditMenuGroup(false);
		}
		else {
			if (pressObj == releaseObj 
                    && pressX == releaseX
                    && pressY == releaseY) {  // click
                EditorFrame.setEditMenuUnGroup(false);
                EditorFrame.setEditMenuChangeName(false);
                clickAction(canvas, pressObj, pressX, pressY);
                canvas.selectedObj = pressObj;
            }
			else {
				int xmove = releaseX - pressX;
                int ymove = releaseY - pressY;
                pressObj.move(canvas, xmove, ymove);
                pressObj.paintObj(canvas);
                pressObj.moveComponentFront(canvas);
                canvas.switchTopComponentToArrayListHead(pressObj);

                for (int i = 0; i < canvas.lineComponents.size(); i++)
                    canvas.lineComponents.get(i).paintObj(canvas);
			}
		}
	}
	

}
