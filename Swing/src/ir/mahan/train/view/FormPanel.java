package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.border.Border;

import ir.mahan.train.model.*;

public class FormPanel extends JPanel implements ActionListener{
	
	private JLabel nameLabel;
	private JLabel familyLabel;
	private JLabel categoryLabel;
	private JLabel genderLabel;
	private JLabel ageLabel;
	private JLabel cityLabel;
	private JLabel sportLabel;
	private JLabel empStatusLabel;
	private JLabel salaryLabel;
	
	private JTextField nameField;
	private JTextField familyField;
	private JComboBox categoryCombo;
	private JComboBox genderCombo;
	private JTextField ageField;
	private JTextField salaryField;
	
	private JList sportList;
	
	private JCheckBox empStatusCheck;
	
	private JButton submitButton;
	
	private CityPanel cityPanel;
	
	
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
		sportLabel = new JLabel("Sport(s): ");
		empStatusLabel = new JLabel("Emp. Status: ");
		salaryLabel = new JLabel("Salary: ");
		
		nameField = new JTextField(10);
		familyField = new JTextField(10);
		categoryCombo = new JComboBox(Category.values());
		genderCombo = new JComboBox(Gender.values());
		ageField = new JTextField(10);
		salaryField = new JTextField(10);
		
		sportList = new JList(Sport.values());
		
		empStatusCheck = new JCheckBox("Is Employee?");
		
		submitButton = new JButton("Submit");
		
		cityPanel = new CityPanel();
		
		categoryCombo.setSelectedIndex(-1);
		genderCombo.setSelectedIndex(-1);
		sportList.setSelectedIndex(-1);
		
		sportList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		salaryField.setEnabled(false);
		
		
		empStatusCheck.addActionListener(this);
		submitButton.addActionListener(this);
		
		
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
		add(categoryCombo, gc);
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
		add(genderCombo, gc);
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
		add(ageField, gc);
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
		add(cityPanel, gc);
		//
		
		//Sport
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(sportLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(sportList, gc);
		//
		
		//Employment Status
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(empStatusLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(empStatusCheck, gc);
		//
		
		//Salary
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(salaryLabel, gc);
		
		gc.gridx ++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(salaryField, gc);
		//
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitButton, gc);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object component = (Object) event.getSource();
		
		if (component == empStatusCheck) {
			event_empStatusCheck();
		}
		
		if (component == submitButton) {
			if (istringListener != null) {
				
				event_subbmitButton();
				
			}
		}		
	}
	
	private void event_empStatusCheck() {
			
		salaryField.setEnabled(empStatusCheck.isSelected());
			
	}
	
	private void event_subbmitButton() {
		
		Person person = new Person();
		
		person.firstName = nameField.getText();
		person.lastName = familyField.getText();
		person.gender = Gender.valueOf(genderCombo.getSelectedItem().toString());
		person.age = Integer.parseInt(ageField.getText());
		person.category = Category.valueOf(categoryCombo.getSelectedItem().toString());
		//if (cityPanel.cityTehranField.isSelected() == true)
		//	person.city.add(City.Tehran);
		//if (cityPanel.cityKermanField.isSelected() == true)
		//	person.city.add(City.Kerman);
		person.sport = sportList.getSelectedValuesList();
		person.isEmployee = empStatusCheck.isSelected();
		if (person.isEmployee == true)
			person.salary = Long.parseLong(salaryField.getText());
		else
			person.salary = 0;
		
		
		StringBuilder stringPerson = new StringBuilder();
		
		stringPerson.append("First Name: "+person.firstName);
		stringPerson.append("; Last Name: "+person.lastName);
		stringPerson.append("; Gender: "+person.gender);
		stringPerson.append("; Age: "+person.age);
		stringPerson.append("; Category: "+person.category);
		stringPerson.append("; City: "+person.city);
		stringPerson.append("; Sport: "+person.sport);
		if (person.isEmployee == true)
			stringPerson.append("; Salary: "+person.salary);
		
		istringListener.strginEmmited(stringPerson.toString());
			
	}

	public void setIstringListener(IstringListener istringListener) {
		
		this.istringListener = istringListener;
	
	}
}
