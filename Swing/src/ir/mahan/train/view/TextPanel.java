package ir.mahan.train.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextPanel extends JPanel{
	
	private JTextArea textArea;
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public TextPanel() {
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);;
		
		
//		Border innerBorder = BorderFactory.createTitledBorder("TextArea"); 
//		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5); 
//		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
//		
		
		
		setBorder(BorderFactory.createTitledBorder("TextArea"));
		
		add(new JScrollPane(textArea) ,BorderLayout.CENTER);
		
	}
	public void setText(String str){
		this.textArea.append(str + "\n");
	}
	
}
