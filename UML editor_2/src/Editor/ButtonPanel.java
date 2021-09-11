package Editor;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Button.BasicBtn;
import Button.AssociationBtn;
import Button.ClassBtn;
import Button.CompositionBtn;
import Button.GenerationBtn;
import Button.SelectBtn;
import Button.UseCaseBtn;

public class ButtonPanel extends JPanel {
	public int btncnt = 0;
	public static ArrayList<BasicBtn> btnList = new ArrayList<BasicBtn>();
	private BasicBtn associationBtn, classBtn, compositionBtn, generationBtn, selectBtn, useCaseBtn;
	
	public ButtonPanel() {
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		int btnWidth = 70, btnHeight = 70;
		int x = 20, y = 20;
		
		selectBtn = new SelectBtn(new ImageIcon("icon/select.png"), x, y, btnWidth, btnHeight);
        btnList.add(selectBtn);
        this.add(selectBtn);
        btncnt += 1;
        y += 90;
        
        associationBtn = new AssociationBtn(new ImageIcon("icon/associate.png"), x, y, btnWidth, btnHeight);
        btnList.add(associationBtn);
        this.add(associationBtn);
        btncnt += 1;
        y += 90;
        
        generationBtn = new GenerationBtn(new ImageIcon("icon/generalize.png"), x, y, btnWidth, btnHeight);
        btnList.add(generationBtn);
        this.add(generationBtn);
        btncnt += 1;
        y += 90;
        
        compositionBtn = new CompositionBtn(new ImageIcon("icon/composite.png"), x, y, btnWidth, btnHeight);
        btnList.add(compositionBtn);
        this.add(compositionBtn);
        btncnt += 1;
        y += 90;
        
        classBtn = new ClassBtn(new ImageIcon("icon/class.png"), x, y, btnWidth, btnHeight);
        btnList.add(classBtn);
        this.add(classBtn);
        btncnt += 1;
        y += 90;
        
        useCaseBtn = new UseCaseBtn(new ImageIcon("icon/use_case.png"), x, y, btnWidth, btnHeight);
        btnList.add(useCaseBtn);
        this.add(useCaseBtn);
        btncnt += 1;
	
	}

}
