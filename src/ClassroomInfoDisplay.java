import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class ClassroomInfoDisplay extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField treeDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClassroomInfoDisplay dialog = new ClassroomInfoDisplay(new Classroom());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClassroomInfoDisplay(Classroom room) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane className = new JTextPane();
			className.setBounds(25, 5, 95, 20);
			className.setText("Name: "+ room.getName());
			contentPanel.add(className);
		}
		

		JTextPane applianceList = new JTextPane();
		applianceList.setBounds(25, 67, 377, 122);
		String str ="Appliances: \n";
		for(int i=0;i<room.getAppliances().size();i++){
			str+=room.getAppliances().get(i).getQuantity() + " " + room.getAppliances().get(i).getName()+ ":" +room.getAppliances().get(i).calcDailyConsumption()+" kW in 24h"; 
		}
		applianceList.setText(str);
		contentPanel.add(applianceList);
		
		treeDescription = new JTextField();
		treeDescription.setBounds(25, 197, 177, 20);
		treeDescription.setText("Equivalent To: "+ School.calcTrees(room.calcClassConsumption())+ " trees");
		contentPanel.add(treeDescription);
		treeDescription.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
