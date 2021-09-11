package Mode;

import Editor.Canvas;
import Pattern.BasicObject;
import Pattern.ClassObj;

public class ClassMode extends BasicMode{

	@Override
	public void clickAction(Canvas canvas, BasicObject currentClickObj, int x, int y) {
		// TODO Auto-generated method stub
		if(currentClickObj != null)
			return;
		canvas.objectComponents.add(new ClassObj(canvas, x, y));
	}

	@Override
	public void releaseAction(Canvas canvas, BasicObject pressObj, BasicObject releaseObj, int pressX, int pressY,
			int releaseX, int releaseY) {
		// TODO Auto-generated method stub
		clickAction(canvas, pressObj, releaseX, releaseY);
	}
	
}
