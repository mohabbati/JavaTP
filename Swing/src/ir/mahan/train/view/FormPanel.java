package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel implements ActionListener{
	
	private JLabel nameLabel;
	private JLabel familyLabel;
	private JLabel categoryLabel;
	private JLabel genderLabel;
	private JLabel ageLabel;
	private JLabel cityLabel;
	private JTextField nameField;
	private JTextField familyField;
	private JComboBox categoryField;
	private JComboBox genderField;
	private JRadioButton age18Field;
	private JRadioButton age20Field;
	private JRadioButton age30Field;
	private JCheckBox cityTehranField;
	private JCheckBox cityKermanField;
	private JButton okBtn;
	
	private IstringListener istringListener;
	
	public FormPanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 280;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		familyLabel = new JLabel("Family: ");
		categoryLabel = new JLabel("Category: ");
		genderLabel = new JLabel("Gender: ");
		ageLabel = new JLabel("Age: ");
		cityLabel = new JLabel("City: ");
		
		nameField = new JTextField(10);
		familyField = new JTextField(10);
		categoryField = new JComboBox();
		genderField = new JComboBox();
		age18Field = new JRadioButton();
		age20Field = new JRadioButton();
		age30Field = new JRadioButton();
		cityTehranField = new JCheckBox();
		cityKermanField = new JCheckBox();
		okBtn = new JButton("Submit");
		
		okBtn.addActionListener(this);
		
		categoryField.addItem("Student");
		categoryField.addItem("Teacher");
		categoryField.addItem("Staff");
		
		genderField.addItem("Female");
		genderField.addItem("Male");
		
		age18Field.setText("18");
		age20Field.setText("20");
		age30Field.setText("30");
		
		cityTehranField.setText("Tehran");
		cityKermanField.setText("Kerman");
		
		Border innerBorder = BorderFactory.createTitledBorder("User Panel"); 
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5); 
		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
		setLayout(new GridBagLayout());
		layoutComponent() ;
	}
	public void layoutComponent() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		add(nameField, gc);

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridy=1;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		
		add(familyLabel, gc);

		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(familyField, gc);

		
		//Category
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(categoryLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(categoryField, gc);
		//
		
		//Gender
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(genderLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(genderField, gc);
		//
		
		//Age
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(ageLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(age18Field, gc);
		
		gc.gridy ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(age20Field, gc);
		
		gc.gridy ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(age30Field, gc);
		//
		
		//City
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(cityLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(cityTehranField, gc);
		
		gc.gridy ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(cityKermanField, gc);
		//
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton component = (JButton) event.getSource();
		if (component == okBtn) {
			if (istringListener != null) {
				
				String age = "";
				String city = "";
				
				if (age18Field.isSelected() == true)
					age = age18Field.getText();
				if (age20Field.isSelected() == true)
					age = age20Field.getText();
				if (age30Field.isSelected() == true)
					age = age30Field.getText();
				
				if (cityTehranField.isSelected() == true)
					city = cityTehranField.getText();
				if (cityKermanField.isSelected() == true)
				{
					if (city == "")
						city = cityKermanField.getText();
					else
						city = city + ", " + cityKermanField.getText();
				}
				
				istringListener.strginEmmited("Name: "+nameField.getText()
											+"; Family: "+familyField.getText()
											+"; Category: "+categoryField.getSelectedItem()
											+"; Gender: "+genderField.getSelectedItem()
											+"; Age: "+age
											+"; City: "+city);
			}
		}
	}

	public void setIstringListener(IstringListener istringListener) {
		this.istringListener = istringListener;
	}
}
