package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuJPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	public MenuJPanel(){
		super(new BorderLayout());
		setSize(new Dimension(500,100));

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems

		ImageIcon img = new ImageIcon("./resources/Queen-icon.png");
		Image im = img.getImage();
		im = im.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(im);
				
		menuItem = new JMenuItem("Author: AgazorSuRoot(github)",img);
		
		menuItem.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuItem, "URL:https://github.com/AgazorSuRoot/8_QUEENS.git");
			}
		});
		
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuBar.add(menu);
		
		add("West",menuBar);
	}
}
