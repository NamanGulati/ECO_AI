import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


/**
 * @author Naman G
 * @date 6/13/18
 *
 * Creates the display pannel for each classroom using JDialog
 */
public class ClassroomInfoDisplay extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField treeDescription;
	static boolean indicator=false;

	

	//Constructor - builds pannel by specified clasroom
	public ClassroomInfoDisplay(Classroom room) {
		setBounds(100, 100, 450, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane className = new JTextPane();
			className.setBounds(25, 5, 377, 20);
			className.setText("Name: "+ room.getName());
			contentPanel.add(className);
		}

		{
			JTextPane applianceList = new JTextPane();
			applianceList.setBounds(25, 36, 377, 205);
			String str ="Appliances: \n";
			for(int i=0;i<room.getAppliances().size();i++){
				System.out.println(room.getAppliances().get(i).getQuantity() + " " + room.getAppliances().get(i).getName()+ ": " +room.getAppliances().get(i).calcDailyConsumption()+" kWh\n");
				str+=room.getAppliances().get(i).getQuantity() + "    "+room.getAppliances().get(i).getType().toUpperCase()+":    " + room.getAppliances().get(i).getName()+ "  (" +room.getAppliances().get(i).calcDailyConsumption()+" kWh) \n"; 
			}
			applianceList.setText(str);
			contentPanel.add(applianceList);
		}

		treeDescription = new JTextField();
		treeDescription.setBounds(25, 252, 177, 20);
		treeDescription.setText("Equivalent To: "+ String.format("%.2f",School.calcTrees(room.calcClassConsumption()))+ " trees");
		contentPanel.add(treeDescription);
		treeDescription.setColumns(10);
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditDataPane.run(room);
			}
		});
		btnEditData.setBounds(335, 252, 89, 23);
		contentPanel.add(btnEditData);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
