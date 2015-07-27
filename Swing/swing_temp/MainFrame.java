package ir.mahan.train.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{

	private TxtPanel txtPanel;
	private FormPanel formPanel;
	private MenuToolBar menuToolBar;
	private String[] result = new String[10];

	public MainFrame(String title) {
		super(title);
		this.setView();
		this.addComponent();
	}

	private void setView() {

		this.setSize(1000, 600);
		this.setLayout(new BorderLayout());
		this.setVisible(true);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	private void addComponent() {

		txtPanel = new TxtPanel();
		formPanel = new FormPanel();
		menuToolBar = new MenuToolBar(); 
		
		this.add(formPanel, BorderLayout.CENTER);
		this.setJMenuBar(menuToolBar.createComponent());
		this.add(txtPanel,BorderLayout.EAST);
		formPanel.setIstreamListener(new IstreamListener() {
			
			@Override
			public void Emmited(Employee myEmployee) {
				// TODO Auto-generated method stub
				int j = 0;
				result[0] = myEmployee.getfName();
				result[1] = myEmployee.getlName();
				result[2] = myEmployee.getCategoty();
				result[3] = myEmployee.getGender();
				
				
				j=4;
				for (int i = 0; i < myEmployee.getCity().length; i++) {
					result[j] = myEmployee.getCity()[i];
					++j;
				}
				
				result[7] = myEmployee.getSport();
				
				
				for (int i = 0; i < result.length; i++) {
					txtPanel.txtArea.append(result[i]);
					txtPanel.txtArea.append("::");
				}
				txtPanel.txtArea.append("\n");
				
			}
		});

	}

	

}
