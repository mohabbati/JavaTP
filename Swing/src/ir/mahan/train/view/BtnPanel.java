package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BtnPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4827286426324448157L;
	private JButton okButton;
	private JButton cancelButton;
	
	private IstringListener istringListener;

	public BtnPanel() {

		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Dimension dim = getPreferredSize();
		dim.height = 50;
		setPreferredSize(dim);
		
		setBorder(BorderFactory.createEtchedBorder());
				
		add(okButton);
		add(cancelButton);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton component = (JButton) event.getSource();
		if (component == okButton) {
			if (istringListener!=null) {
				istringListener.strginEmmited("Ok");
			}
		} else {
			istringListener.strginEmmited("Cancel");
		}

	}

	public void setIstringListener(IstringListener istringListener) {
		this.istringListener = istringListener;
	}
}
