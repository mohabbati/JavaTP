package ir.mahan.train.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuPanel extends JPanel implements ActionListener {
	
	private IstringListener istringListener;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem saveToFileMenuItem;
	private JMenuItem loadFromFileMenuItem;
	private JMenuItem exitMenuItem;
	
	public MenuPanel() {
		
		createMenuBar();
		
	}
	
	private void createMenuBar() {
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		saveToFileMenuItem = new JMenuItem("Save to File");
		loadFromFileMenuItem = new JMenuItem("Load from File");
		exitMenuItem = new JMenuItem("Exit");
		
		//setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		
		fileMenu.add(saveToFileMenuItem);
		fileMenu.add(loadFromFileMenuItem);
		fileMenu.add(exitMenuItem);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JMenuItem component = (JMenuItem) event.getSource();
		if (component == exitMenuItem) {
			if (istringListener!=null) {
				istringListener.strginEmmited("Exit");
			}
		}
	}

	public void setIstringListener(IstringListener istringListener) {
		this.istringListener = istringListener;
	}
}
