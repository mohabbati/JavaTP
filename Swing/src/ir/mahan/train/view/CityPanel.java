package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class CityPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4306168673428481919L;

	public JCheckBox cityTehranField;
	public JCheckBox cityKermanField;
	
	public CityPanel() {
		
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
