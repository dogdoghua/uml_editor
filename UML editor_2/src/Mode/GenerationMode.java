package Mode;

import Editor.Canvas;
import Pattern.BasicObject;
import Pattern.GenerationLine;
import Pattern.GroupObj;

public class GenerationMode extends BasicMode{

	@Override
	public void releaseAction(Canvas canvas, BasicObject pressObj, BasicObject releaseObj, int pressX, int pressY,
			int releaseX, int releaseY) {
		// TODO Auto-generated method stub
		if (pressObj == null || releaseObj == null
                || pressObj instanceof GroupObj || releaseObj instanceof GroupObj)  // press at blank or release at blank or
                                                                                                   // create line to group object
            return;
        if (releaseObj == pressObj)
            return;
        else
            canvas.lineComponents.add(new GenerationLine(canvas, pressX, pressY, releaseX, releaseY, pressObj,
                    releaseObj));
	}

}
