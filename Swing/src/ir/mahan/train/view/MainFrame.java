package ir.mahan.train.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class MainFrame extends JFrame{

	public TextPanel textPanel;
	public FormPanel formPanel;
	
	public MainFrame(String title) {
		
		super(title);
		this.setView();
		this.createMenuBar();
		this.addComponent();
		
	}

	private void addComponent() {
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		formPanel.setIstringListener(new IstringListener() {
			
			@Override
			public void strginEmmited(String input) {
				textPanel.setText(input);
				
			}
		});
		
		this.add(formPanel,BorderLayout.WEST);
		this.add(textPanel,BorderLayout.EAST);
		
	}

	private void setView() {
		
		this.setSize(600, 600);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//Menu Bar
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem saveToFileMenuItem;
	private JMenuItem loadFromFileMenuItem;
	private JMenuItem exitMenuItem;
	private JSeparator separator;
	
	private void createMenuBar() {
	
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		saveToFileMenuItem = new JMenuItem("Save to File");
		loadFromFileMenuItem = new JMenuItem("Load from File");
		exitMenuItem = new JMenuItem("Exit");
		separator = new JSeparator();
		
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		
		fileMenu.add(saveToFileMenuItem);
		fileMenu.add(loadFromFileMenuItem);
		fileMenu.add(separator);
		fileMenu.add(exitMenuItem);
		
	}
	
}