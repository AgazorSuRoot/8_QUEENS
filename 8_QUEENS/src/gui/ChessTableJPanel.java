package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ChessTableJPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private int n;
	public ChessTableJPanel(int n){
		super(new GridLayout(n, n, 1, 1));
		this.n = n;
		setSize(new Dimension(400,400));
		setBorder(BorderFactory.createEmptyBorder(25, 25, 25 ,25));
		
		for ( int i = 0; i < n; i++){
			for ( int j = 0; j < n; j++){
				add(new CellJButton(i,j,this), i * n + j);
			}
		}
	}
	
	public void changeSize(int n){
		this.removeAll();
		for ( int i = 0; i < n; i++){
			for ( int j = 0; j < n; j++){
				add(new CellJButton(i,j,this), i * n + j);
			}
		}
		repaint();
	}
	
	public void update(int arr[]){
		CellJButton button;
		int column;
		for (int row = 0; row < n ; row++){
			column = arr[row];
			button = (CellJButton)this.getComponent( row * n + column);
			button.setText("Q");
		}
	}
	
	public void update(){
		CellJButton buttonA, buttonB; 
		int i1,j1,i2,j2;
		boolean flag;
		for (int i = 0; i < n * n; i++){
			flag = false;
			buttonA = (CellJButton)this.getComponent(i);
			if ( buttonA.isQueen() ){
				i1 = buttonA.i;
				j1 = buttonA.j;
				for ( int j = 0; j < i; j++){
					buttonB = (CellJButton)this.getComponent(j);
					if ( buttonB.isQueen() ){
						i2 = buttonB.i;
						j2 = buttonB.j;
						if ( ! correct(i1,j1,i2,j2) ){
							flag = true;
						}
					}
				}
				for ( int j = i +1; j < n * n; j++){
					buttonB = (CellJButton)this.getComponent(j);
					if ( buttonB.isQueen() ){
						i2 = buttonB.i;
						j2 = buttonB.j;
						if ( ! correct(i1,j1,i2,j2) ){
							flag = true;
						}
					}
				}
				if (flag){
					buttonA.setBackground(Color.RED);
				}else{
					buttonA.setBackground(buttonA.color);
				}
			}else{
				buttonA.setBackground(buttonA.color);
			}
				
		}
	}
	
	public boolean correct(int i, int j, int ii, int jj){
		
		if ( i == ii || j == jj){
			return false;
		}
		if ( ( ii - i) == (jj - j) || ( ii - i) == (j - jj)){
			return false;
		}
		return true;
	}
}
