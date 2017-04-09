package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CellJButton extends JButton{

	private static final long serialVersionUID = 1L;
	protected int i;
	protected int j;
	protected Color color;

	public CellJButton(int i, int j,ChessTableJPanel chess){
		super("");
		this.color = getBackground();
		this.i = i;
		this.j = j;
		
		setFont(new Font("Serif", Font.BOLD, 20));
		addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				CellJButton button = ((CellJButton)e.getSource());
				
				if ( button.isQueen()){
					button.setText("");
				}else{
					button.setText("Q");
				}
				chess.update();
			}
		});
	}
	
	public boolean isQueen(){
		return getText().equals("Q");
	}
	
	public boolean isRed(){
		return getBackground() == Color.RED;
	}
}
