package ir.mahan.train.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

	public TextPanel textPanel;
	public FormPanel formPanel;
	private JFileChooser fileChooser;
	
	public MainFrame(String title) {

		super(title);
		this.setView();
		this.createMenuBar();
		this.addComponent();
		
		fileChooser = new JFileChooser();
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
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

		this.add(formPanel, BorderLayout.WEST);
		this.add(textPanel, BorderLayout.EAST);

	}

	private void setView() {

		this.setSize(600, 600);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// Menu Bar

	private void createMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenu windowsMenu = new JMenu("Windows");
		JMenu showMenu = new JMenu("Show");

		JMenuItem saveToFileMenuItem = new JMenuItem("Save to File");
		JMenuItem loadFromFileMenuItem = new JMenuItem("Load from File");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		JSeparator separator = new JSeparator();

		JMenuItem preferencesMenuItem = new JMenuItem("Preferences");

		JMenuItem personFormMenuItem = new JMenuItem("Person Form");

		menuBar.add(fileMenu);
		menuBar.add(windowsMenu);
		menuBar.add(showMenu);

		fileMenu.add(saveToFileMenuItem);
		fileMenu.add(loadFromFileMenuItem);
		fileMenu.add(separator);
		fileMenu.add(exitMenuItem);

		windowsMenu.add(preferencesMenuItem);

		showMenu.add(personFormMenuItem);

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitMenuItem.setMnemonic(KeyEvent.VK_X);

		setJMenuBar(menuBar);

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				int action  = JOptionPane.showConfirmDialog(MainFrame.this,
						"DO you want to Exit?",
						"Exit Confirmation",
						JOptionPane.OK_CANCEL_OPTION);
				
				if(action == JOptionPane.OK_OPTION){
				
					System.exit(0);
					
				}
				
			}
		});
		
		saveToFileMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					
				}
				
			}
		});
		
		loadFromFileMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					
				}
				
			}
		});
	}

}