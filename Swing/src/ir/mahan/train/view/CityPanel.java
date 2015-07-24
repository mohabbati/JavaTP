package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class CityPanel extends JPanel {

	private JLabel cityLabel;
	
	public JCheckBox cityTehranField;
	public JCheckBox cityKermanField;
	
	public CityPanel() {
		
		cityLabel = new JLabel("City: ");
		
		cityTehranField = new JCheckBox();
		cityKermanField = new JCheckBox();
		
		cityTehranField.setText("Tehran");
		cityKermanField.setText("Kerman");
		
		Dimension dimCity = getPreferredSize();
		dimCity.height = 20;
		dimCity.width = 50;
		
		//cityLabel.setSize(dimCity);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		cityTehranField.setSize(dimCity);
		cityKermanField.setSize(dimCity);
		
		//add(cityLabel);
		add(cityTehranField);
		add(cityKermanField);
	}
}
