import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class test extends JPanel {

	/**
	 * Create the panel.
	 */
	public test() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 5, 344, 227);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

	}

}
