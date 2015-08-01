package ir.mahan.train.view;

import ir.mahan.train.model.Person;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3814330673013507794L;
	
	private JTable table;
	
	private PersonTableModel personTableModel;
	
	public TablePanel() {
		
		personTableModel = new PersonTableModel();
		
		table = new JTable(personTableModel);
		setLayout(new BorderLayout());
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		setBorder(BorderFactory.createTitledBorder("TextArea"));
		
		add(new JScrollPane(table) ,BorderLayout.CENTER);
		
	}
	
	public void setData(List<Person> db) {
		
		personTableModel.setData(db);
		
	}
	
	public void refresh() {
		
		personTableModel.fireTableDataChanged();
		
	}
	
}
