package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Queens_Frame extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	private Queens_GUI queenPanel;
	public Queens_Frame(int n){
	
		super("QUEENS PROBLEM");
		queenPanel = new Queens_GUI(n);
		setSize(850,550);
	    setLocation(100, 100);
	    	    
		try {
			setIconImage(ImageIO.read(new FileInputStream("./resources/Queen-icon.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(queenPanel);
		setVisible(true);
	}
}
