package Mode;

import Editor.Canvas;
import Pattern.AssociationLine;
import Pattern.BasicObject;
import Pattern.CompositionLine;
import Pattern.GroupObj;

public class CompositionMode extends BasicMode{

	@Override
	public void releaseAction(Canvas canvas, BasicObject pressObj, BasicObject releaseObj, int pressX, int pressY,
			int releaseX, int releaseY) {
		// TODO Auto-generated method stub
		if(pressObj == null || releaseObj == null ||
				pressObj instanceof GroupObj || releaseObj instanceof GroupObj)
			return;
		if(releaseObj == pressObj)
			return;
		else
			canvas.lineComponents.add(new CompositionLine(canvas, pressX, pressY, releaseX, releaseY, pressObj, releaseObj));
		
	}
	

}
