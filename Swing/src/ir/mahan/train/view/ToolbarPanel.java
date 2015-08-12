package ir.mahan.train.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolbarPanel extends JToolBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4827286426324448157L;
	private JButton saveButton;
	private JButton refreshButton;
	
	private ItoolbarListener itoolbarListener;

	public ToolbarPanel() {
		
		setBorder(BorderFactory.createEtchedBorder());
		setFloatable(false);
		
		saveButton = new JButton();
		refreshButton = new JButton();
		
		saveButton.addActionListener(this);
		refreshButton.addActionListener(this);
		
		saveButton.setIcon(Utils.createIcon("/images/Save16.gif"));
		refreshButton.setIcon(Utils.createIcon("/images/Refresh16.gif"));
		
		saveButton.setToolTipText("Save to Database");
		refreshButton.setToolTipText("Refresh Data");
		
		add(saveButton);
		add(refreshButton);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton component = (JButton) event.getSource();
		if (component == saveButton) {
			if (itoolbarListener!=null) {
				if (component.getName() == "saveButton") {
					itoolbarListener.saveEventOcured();
				}
				
				if (component.getName() == "refreshButton") {
					itoolbarListener.refreshEventOcured();
				}
			}
		}
	}

	public void setItoolbarListener(ItoolbarListener itoolbarListener) {
		this.itoolbarListener = itoolbarListener;
	}
}