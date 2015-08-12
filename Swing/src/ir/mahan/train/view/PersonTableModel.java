package ir.mahan.train.view;

import ir.mahan.train.model.Person;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1448194310087091927L;
	
	private List<Person> db;
	private String[] colName = {"ID", "FirstName", "LastName", "Gender", "Age", "Category", "City", "Sport", "IsEmployee", "Salary"};
	
	public void setData(List<Person> db) {
		
		this.db = db;
		
	}
	
	@Override
	public int getColumnCount() {
		
		return colName.length;
		
	}

	@Override
	public int getRowCount() {

		return db.size();
		
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		Person person = db.get(row);
		
		switch (col) {
		case 0:
			return person.ID;
		case 1:
			return person.firstName;
		case 2:
			return person.lastName;
		case 3:
			return person.gender;
		case 4:
			return person.age;
		case 5:
			return person.category;
		case 6:
			return person.city;
		case 7:
			return person.sport;
		case 8:
			return person.isEmployee;
		case 9:
			return person.salary;
		}
		
		return null;
		
	}
	
	@Override
	public String getColumnName(int column) {

		return colName[column];
		
	}
	
public boolean isCellEditable(int row, int col) {
		
		switch (col) {
		case 1:
			return true;
		case 2:
			return true;
		case 3:
			return true;
			
		default:
			return false;
		}
		
	}
	
	public void setValueAt(Object value, int row, int col) {

		if (db == null) {
			
			return;
		
		}
		
		Person person = db.get(row);
		
		switch (col) {
		case 1:
			person.setFirstName((String) value); 
			break;
		case 2:
			person.setLastName((String) value); 
			break;
		case 3:
			person.setAge((int) value); 
			break;
			
		default:
			
			return;
			
		}
		
	}

}