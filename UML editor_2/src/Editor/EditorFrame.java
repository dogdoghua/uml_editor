package Editor;
import javax.swing.*;

import Mode.BasicMode;

public class EditorFrame {
	private JFrame mainFrame = new JFrame("uml editor");
	private static MenuBar menuBar = new MenuBar();
	public static ButtonPanel buttonPanel = new ButtonPanel();
	public static Canvas canvas = new Canvas();
	
	public EditorFrame() {
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		mainFrame.setJMenuBar(menuBar);
		
		int buttonPanelWidth = 20 + 70 + 20;
		int buttonPanelHeight = 20 + (70 + 20) * buttonPanel.btncnt;
		buttonPanel.setLocation(20, 20);
		buttonPanel.setSize(buttonPanelWidth, buttonPanelHeight);
		mainFrame.add(buttonPanel);
		
		
		int canvasWidth = 200 + 20 + (70 + 20) * buttonPanel.btncnt;
		int canvasHeight = 20 + (70 + 20) * buttonPanel.btncnt;
		canvas.setLocation(20+(20+70+20)+20, 20);
		canvas.setSize(canvasWidth, canvasHeight);
		mainFrame.add(canvas);
		
		mainFrame.setSize(20 + buttonPanelWidth + 20 + canvasWidth + 20, 20 + canvasHeight + 20 + 40);
		mainFrame.setVisible(true);
	}
	
	public static void setCurrentMode(BasicMode mode) {
		Canvas.currentMode = mode;
	}
	public static void menuSetGroupComponents() {
		canvas.setGroupComponents();
	}
	public static void menuRmGroupComponents() {
		canvas.rmGroupComponents();
	}
	public static void menuChangeName() {
		Object objectName = JOptionPane.showInputDialog(null, "Enter object name: ", "Change object name ", 0, null, null, "");
		if(objectName != null) {
			canvas.selectedObj.changeName(objectName.toString());
			
		}
	}
	public static int getSideBtnNumber() {
		return buttonPanel.btncnt;
	}
	public static void setEditMenuGroup(boolean b) {
		menuBar.edit_group.setEnabled(b);
	}
	public static void setEditMenuUnGroup(boolean b) {
		menuBar.edit_ungroup.setEnabled(b);
	}
	public static void setEditMenuChangeName(boolean b) {
		menuBar.edit_changeName.setEnabled(b);
	}

}
