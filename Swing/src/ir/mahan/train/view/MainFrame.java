package ir.mahan.train.view;

import ir.mahan.train.model.Person;
import ir.mahan.train.repository.FileRepository;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2939449444417001502L;

	private List<Person> people;
	
	public ToolbarPanel toolBar;
	public TextPanel textPanel;
	public FormPanel formPanel;
	public TablePanel tablePanel;
	private JFileChooser fileChooser;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	
	public MainFrame(String title) {
		
		super(title);
		
		people = new LinkedList<Person>();
		
		this.setView();
		this.createMenuBar();
		this.addComponent();
		
		tablePanel.setData(people);
		
		fileChooser = new JFileChooser();
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
	}
	
	private void addComponent() {
		toolBar = new ToolbarPanel();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		tabbedPane = new JTabbedPane();
		tablePanel = new TablePanel();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabbedPane);
		
		tabbedPane.add("Text Area", textPanel);
		tabbedPane.add("Person Table", tablePanel);
		splitPane.setOneTouchExpandable(true);
		
		this.add(splitPane, BorderLayout.CENTER);
		this.add(toolBar, BorderLayout.PAGE_START);
		
		formPanel.setIstringListener(new IstringListener() {

			@Override
			public void strginEmmited(Object object) {
				
				people.add((Person) object);
				
				textPanel.setText((Person4Show((Person) object)));
				
				tablePanel.refresh();
				
			}
		});
		
		
		tablePanel.addPersonTableListener(new PersonTableListener() {
			
			@Override
			public void rowDeleted(int row) {
				
				people.remove(row);
				
				tablePanel.setData(people);
				
			}
		});

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
		
		JCheckBoxMenuItem showFormCheckBoxItem = new JCheckBoxMenuItem("Show the Form");
		showFormCheckBoxItem.setSelected(true);
		
		menuBar.add(fileMenu);
		menuBar.add(windowsMenu);
		menuBar.add(showMenu);

		fileMenu.add(saveToFileMenuItem);
		fileMenu.add(loadFromFileMenuItem);
		fileMenu.add(separator);
		fileMenu.add(exitMenuItem);

		windowsMenu.add(preferencesMenuItem);
		showMenu.add(personFormMenuItem);
		showMenu.add(showFormCheckBoxItem);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitMenuItem.setMnemonic(KeyEvent.VK_X);
		
		saveToFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		loadFromFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		preferencesMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		setJMenuBar(menuBar);

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				int action  = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you want to Exit?",
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
					
					FileRepository fileRepository = new FileRepository(fileChooser.getSelectedFile());
					
					List<Object> objects = new LinkedList<Object>();
					
					objects = (List<Object>)(Object)people;
					
					fileRepository.Save(objects);
					
				}
								
			}
		});
		
		loadFromFileMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){

					FileRepository fileRepository = new FileRepository(fileChooser.getSelectedFile());
					
					String stringPerson;
					
					stringPerson = fileRepository.Retrieve();
					
					ObjectMapper objectMapper = new ObjectMapper();
					
					people.removeAll(people);
					
					try {
						
						people = objectMapper.readValue(stringPerson, new TypeReference<List<Person>>(){});
						
					} catch (IOException e) {

						e.printStackTrace();
						
					}
					
					for (Person person : people) {
						
						textPanel.setText(Person4Show(person));
						
					}
					
					tablePanel.setData(people);
					tablePanel.refresh();
					
				}
				
			}
		});
		
	}
	
	String Person4Show(Person person) {
		
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
		
		return stringPerson.toString();
		
	}

}