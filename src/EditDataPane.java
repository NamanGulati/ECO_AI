import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

/**
 * @author Naman G
 * @date 6/16/18
 * 
 * Creates the appliance selection pane to edit data
 */
public class EditDataPane extends JPanel {
	private JTextField txtClassroom;
	
	//Constructor -- creates the text feild and radio buttons
	public EditDataPane(Classroom cl) {
		FormLayout fl = new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,});
		setLayout(fl);

		txtClassroom = new JTextField();
		txtClassroom.setText(cl.getName());
		add(txtClassroom, "2, 2, fill, top");
		txtClassroom.setColumns(10);
		
	
		
		//JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		//add(rdbtnNewRadioButton, "2, 4");
		
		int row=4;
		int col=2;

		for(int i=0;i<cl.getAppliances().size();i++){
			JRadioButton rdbtnAppliance = new JRadioButton(cl.getAppliances().get(i).getName());
			Appliance appl=cl.getAppliances().get(i);
			final int index=i;
			rdbtnAppliance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InputDataDialog input = new InputDataDialog(appl);
					input.setVisible(true);
					ClassroomInfoDisplay.indicator=false;
					cl.getAppliances().set(index, appl);
				}
			});
			if(row>fl.getRowCount()){
				row=4;
				col+=2;
			}
			if(col>fl.getColumnCount()){
				col=2;
				row=4;
			}
			add(rdbtnAppliance, (col+", "+row));
			row+=2;
		}
		if(row>fl.getRowCount()){
			row=4;
			col+=2;
		}
		if(col>fl.getColumnCount()){
			col=2;
			row=4;
		}
		JRadioButton rdbtnAddAppliance = new JRadioButton("Add Appliance");
		rdbtnAddAppliance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Appliance appl = new Appliance();
				InputDataDialog input = new InputDataDialog(appl);
				input.setVisible(true);
				cl.getAppliances().add(appl);
				
			}
		});
		add(rdbtnAddAppliance, (col+", "+row));
	}
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: creates and shows gui
	 */
	private static void createAndShowGUI(Classroom cl) {
		//Create and set up the window.
		JFrame frame = new JFrame("ECO_AI");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Add content to the window.
		frame.getContentPane().add(new EditDataPane(cl), BorderLayout.CENTER);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: Schedule a job for creating and showing this application's GUI.
	 */
	public static void run(Classroom cl) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI(cl);
			}
		});
	}

}
