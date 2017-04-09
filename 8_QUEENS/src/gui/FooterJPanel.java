package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logic.Queens;

public class FooterJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private  JButton solve ;
	private  JButton solve_All ;
	private  JButton clear;
	
	public FooterJPanel(int n, JTextArea output,ChessTableJPanel chessTablePanel){
		super(new BorderLayout());
		this.solve = new JButton("SOLVE");
		this.solve_All = new JButton("SOLVE_ALL!");
		this.clear = new JButton("CLEAR!");
		
		solve.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				chessTablePanel.update( Queens.eightQueensJustOne(n) );
			}
			
		});
		
		solve_All.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				output.setText(Queens.eightQueens(n).toString());
			}
			
		});
		
		clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				output.setText("");
			}
			
		});
		
		solve.setPreferredSize(new Dimension(250,50));
		solve_All.setPreferredSize(new Dimension(250,50));
		clear.setPreferredSize(new Dimension(300,50));

		
		add("West",solve);
		add("Center",solve_All);
		add("East",clear);
	}
}
