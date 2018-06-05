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
import net.miginfocom.swing.MigLayout;

public class ApplicationPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ApplicationPanel() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();
		
		add(tabbedPane);
		
		for(int i=0;i<MainPrg.stJoes.getFloors().size();i++){
			JPanel floor1 = new JPanel();
			tabbedPane.addTab("Floor"+i, null, floor1, null);

			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			MigLayout layout=new MigLayout("", "[51px][]", "[23px][23px][23px]");
			floor1.setLayout(layout);
			layout.
			for(int j=0;j<MainPrg.stJoes.getFloors().get(i).getClassrooms().size();i++){
				JButton btn = new JButton(MainPrg.stJoes.getFloors().get(i).getClassrooms().get(j).getName());
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(MainPrg.stJoes.getClassroom(btn.getText()));
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				
			}
		}
		
		
		//Button 101
		JButton btn101 = new JButton("101");
		btn101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(MainPrg.stJoes.getClassroom(btn101.getText()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		floor1.add(btn101, "cell 0 0,alignx left,aligny top");
		
		//Button 102
		JButton btn102 = new JButton("102");
		btn102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(School.getClassroom(btn102.getText()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		floor1.add(btn102, "cell 0 1,alignx left,aligny top");
		
		JButton btn103 = new JButton("103");
		btn103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(School.getClassroom(btn103.getText()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		floor1.add(btn103, "cell 0 2,alignx left,aligny top");
		
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
