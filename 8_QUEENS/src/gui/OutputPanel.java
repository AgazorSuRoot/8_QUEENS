package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutputPanel extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private JScrollPane areaScrollPane;
	private JTextArea textArea;
	static private final String MESSAGE = "Click solve to display all posible solutions.";
	
	public OutputPanel(){
		super(new BorderLayout());
		setSize(new Dimension(300,200));
		setMinimumSize( new Dimension(300,200) );
		setPreferredSize( new Dimension(300,200) );
		
		label = new JLabel("Output:");
		
		textArea = new JTextArea( MESSAGE );
		
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(225, 350));
		areaScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 25 ,1));
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add("North",label);
		add("Center",areaScrollPane);
	}
	
	public JTextArea getTextArea(){
		return textArea;
	}
}
