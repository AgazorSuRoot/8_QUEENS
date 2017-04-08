package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import logic.Queens;

public class Queens_GUI extends JPanel{
	
	private int n;
	
	private int[][] chessTable;
	private JPanel chessTablePanel;
	
	private  JButton b1 ;
	
	public Queens_GUI(int n){
		setPreferredSize(new Dimension(750,550));
		setLayout(new BorderLayout());
		this.chessTable = new int[n][n]; 
		chessTablePanel = new JPanel(new GridLayout(n, n, 10, 10));
		//chessTablePanel.setPreferredSize(new Dimension(500,400));
		chessTablePanel.setSize(new Dimension(400,400));

		////
		//Where the GUI is created:
		JPanel myMenu = new JPanel(new BorderLayout());
		myMenu.setSize(new Dimension(500,100));
		
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "This doesn't really do anything");
		menu.add(menuItem);

		ImageIcon img = new ImageIcon("./resources/Queen-icon.png");
		Image im = img.getImage();
		im = im.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(im);
				
		menuItem = new JMenuItem("Both text and icon",img);
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(img);
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		//a group of check box menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		//Build second menu in the menu bar.
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);
		
		myMenu.add("West",menuBar);
		myMenu.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		add("North",myMenu);
		
		///
		
		this.setBorder(BorderFactory.createLineBorder(Color.RED)); 
		JButton cell;
		for ( int i = 0; i < n; i++){
			for ( int j = 0; j < n; j++){
				cell = new JButton("");
				chessTablePanel.add(cell);
				
			}
		}
		
		this.b1 = new JButton("SOLVE!");
		chessTablePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
		add("Center",chessTablePanel);
		add("South",b1);
		
		//
		
		JPanel left = new JPanel();
		left.setSize(new Dimension(200,200));
		left.setMinimumSize( new Dimension(200,200) );
		left.setPreferredSize( new Dimension(200,200) );
		add("West",left);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("QUEENS PROBLEM");
		Queens_GUI queenPanel = new Queens_GUI(8);
		frame.setSize(750,550);
	    frame.setLocation(100, 100);
	    	    
		try {
			frame.setIconImage(ImageIO.read(new FileInputStream("./resources/Queen-icon.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(queenPanel);
		
		frame.setVisible(true);
	}
}
