import javax.swing.SwingUtilities;

import ir.mahan.train.view.MainFrame;


public class StartApp {
	// this is the main entry for program...
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame("myApp");
				
			}
		});

	}

}
