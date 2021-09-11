package Button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Editor.ButtonPanel;


public class BasicBtn extends JButton{
	
	public BasicBtn(ImageIcon icon, int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setIcon(icon);
		this.setContentAreaFilled(true);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAction();
			}

			
		});
		
	}
	protected void btnAction() {
		resetBtnColor();
		BasicBtn.this.setBackground(Color.LIGHT_GRAY);
	}
	
	private void resetBtnColor() {
		for(int i = 0; i < ButtonPanel.btnList.size(); i++) {
            ButtonPanel.btnList.get(i).setBackground(Color.white);
        }
	}

}
