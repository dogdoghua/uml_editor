package Button;

import javax.swing.ImageIcon;

import Editor.EditorFrame;
import Mode.CompositionMode;

public class CompositionBtn extends BasicBtn{

	public CompositionBtn(ImageIcon icon, int x, int y, int width, int height) {
		super(icon, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void btnAction() {
		// TODO Auto-generated method stub
		super.btnAction();
		EditorFrame.setCurrentMode(new CompositionMode());
		
	}
	

}
