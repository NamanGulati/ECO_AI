import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ApplicationPanel() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Add the tabbed pane to this panel.
		add(tabbedPane);

		//The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel floor1 = new JPanel();
		tabbedPane.addTab("Floor 1", null, floor1, null);
		floor1.setLayout(null);
		
		//Button 101
		JButton btn101 = new JButton("101");
		btn101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(School.getClassRoom(btn101.getText()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn101.setBounds(36, 49, 51, 23);
		floor1.add(btn101);
		
		//Button 102
		JButton btn102 = new JButton("102");
		btn102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(School.getClassRoom(btn102.getText()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn102.setBounds(36, 77, 51, 23);
		floor1.add(btn102);
		
		JButton btn103 = new JButton("103");
		btn103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(School.getClassRoom(btn103.getText()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn103.setBounds(36, 104, 51, 23);
		floor1.add(btn103);
		
		JPanel floor2 = new JPanel();
		tabbedPane.addTab("New tab", null, floor2, null);
		
		
	}
	 
	    
	    
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from
	     * the event dispatch thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("TabbedPaneDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Add content to the window.
	        frame.getContentPane().add(new ApplicationPanel(), BorderLayout.CENTER);
	        
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
	    public static void main(String[] args) {
	        //Schedule a job for the event dispatch thread:
	        //creating and showing this application's GUI.
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
			UIManager.put("swing.boldMetal", Boolean.FALSE);
			createAndShowGUI();
	            }
	        });
	    }
}
