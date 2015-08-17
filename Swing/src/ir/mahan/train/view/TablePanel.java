package ir.mahan.train.view;

import ir.mahan.train.model.Person;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3814330673013507794L;
	
	private JTable table;
	
	private PersonTableModel personTableModel;
	
	private JPopupMenu popupMenu;
	
	private PersonTableListener personTableListener;
	
	public TablePanel() {
		
		personTableModel = new PersonTableModel();
		
		popupMenu = new JPopupMenu();
		
		table = new JTable(personTableModel);
		setLayout(new BorderLayout());
		
		JMenuItem removeMenuItem = new JMenuItem("Remove");
		JMenuItem addMenuItem = new JMenuItem("Add");
		JMenuItem refreshMenuItem = new JMenuItem("Refresh");
		
		popupMenu.add(removeMenuItem);
		popupMenu.add(addMenuItem);
		popupMenu.add(refreshMenuItem);
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if (e.getButton() == MouseEvent.BUTTON3) {
					
					popupMenu.show(table, e.getX(), e.getY());
					
				}
			}
			
		});
		
		removeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int row = table.getSelectedRow();
				if (personTableListener != null) {
					personTableListener.rowDeleted(row);
					personTableModel.fireTableDataChanged();
				}
				
			}
		});
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		setBorder(BorderFactory.createTitledBorder("TextArea"));
		
		add(new JScrollPane(table) ,BorderLayout.CENTER);
		
	}
	
	public void addPersonTableListener(PersonTableListener personTableListener) {
		
		this.personTableListener = personTableListener;
		
	}
	
	public void setData(List<Person> db) {
		
		personTableModel.setData(db);
		
	}
	
	public void refresh() {
		
		personTableModel.fireTableDataChanged();
		
	}
	
}
