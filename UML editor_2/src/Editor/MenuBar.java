package Editor;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar{
	private JMenu file = new JMenu("file");
	private JMenu edit = new JMenu("edit");
	
	public JMenuItem edit_group = new JMenuItem("group");
	public JMenuItem edit_ungroup = new JMenuItem("ungroup");
	public JMenuItem edit_changeName = new JMenuItem("change object name");
	
	public MenuBar() {
		this.add(file);
		
		edit_group.setEnabled(false);
		edit_group.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditorFrame.menuSetGroupComponents();
			}
			
		});
		edit.add(edit_group);
		
		edit_ungroup.setEnabled(false);
		edit_ungroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EditorFrame.menuRmGroupComponents();	
			}
		});
		edit.add(edit_ungroup);
		
		edit_changeName.setEnabled(false);
		edit_changeName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EditorFrame.menuChangeName();
			}
		});
		edit.add(edit_changeName);
		this.add(edit);
	}

}
