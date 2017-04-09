package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;


public class Queens_GUI extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private MenuJPanel myMenu;
	private ChessTableJPanel chessTablePanel;
	private OutputPanel right;
	private FooterJPanel footer;
	
	public Queens_GUI(int n){
		
		
		setPreferredSize(new Dimension(750,550));
		setLayout(new BorderLayout());
		
		myMenu = new MenuJPanel();
		add("North",myMenu);
		
		chessTablePanel = new ChessTableJPanel(8);
		add("Center",chessTablePanel);
		
		right = new OutputPanel();
		add("East",right);
		
		footer = new FooterJPanel(n,right.getTextArea(),chessTablePanel);
		add("South",footer);
		
	}
}
