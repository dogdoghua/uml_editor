package Button;

import javax.swing.ImageIcon;

import Editor.EditorFrame;
import Mode.UseCaseMode;

public class UseCaseBtn extends BasicBtn{
	public UseCaseBtn(ImageIcon icon, int x, int y, int width, int height) {
		super(icon, x, y, width, height);
	}

	@Override
	protected void btnAction() {
		// TODO Auto-generated method stub
		super.btnAction();
		EditorFrame.setCurrentMode(new UseCaseMode());
	}
	

}
