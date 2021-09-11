package Button;

import javax.swing.ImageIcon;

import Editor.EditorFrame;
import Mode.GenerationMode;

public class GenerationBtn extends BasicBtn{

	public GenerationBtn(ImageIcon icon, int x, int y, int width, int height) {
		super(icon, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void btnAction() {
		// TODO Auto-generated method stub
		super.btnAction();
		EditorFrame.setCurrentMode(new GenerationMode());
	}
	
	
}
