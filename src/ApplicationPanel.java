import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ApplicationPanel extends JPanel {
	private JTextField txtDailySchoolConsumption;
	private JTextField txtMostEnergyConsuming;
	private JTextField txtMostEnergyConsuming_1;
	private JTextField txtSchoolDailyEnergy;
	private JTextField txtSchoolMonthlyEnergy;
	private JList list;
	private JButton btnViewGraph;

	/**
	 * Create the panel.
	 */
	public ApplicationPanel() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();

		add(tabbedPane);
		
		

		for(int i=0;i<MainPrg.stJoes.getFloors().size();i++){
			JPanel floor1 = new JPanel();
			tabbedPane.addTab(("Floor"+i), null, floor1, null);

			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			FormLayout fl = new FormLayout(new ColumnSpec[] {
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,},
					new RowSpec[] {
							FormSpecs.RELATED_GAP_ROWSPEC,
							FormSpecs.DEFAULT_ROWSPEC,});
			floor1.setLayout(fl);
			int row=2;
			int col=2;
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
				if(row>fl.getRowCount()){
					row=2;
					col+=2;
				}
				floor1.add(btn, (""+row+", "+col));
				row+=2;
			}
		}
		
		JPanel Analytics = new JPanel();
		tabbedPane.addTab("Analytics", null, Analytics, null);
		Analytics.setLayout(new MigLayout("", "[grow]", "[][][][][][][grow]"));
		
		txtDailySchoolConsumption = new JTextField();
		txtDailySchoolConsumption.setText("Daily School Consumption: "+MainPrg.stJoes.calcSchoolConsumption()+"kWh");
		Analytics.add(txtDailySchoolConsumption, "cell 0 0,growx");
		txtDailySchoolConsumption.setColumns(10);
		
		txtMostEnergyConsuming = new JTextField();
		txtMostEnergyConsuming.setText("Most Energy Consuming Classroom: "+MainPrg.stJoes.findMaxClassroom());
		Analytics.add(txtMostEnergyConsuming, "cell 0 1,growx");
		txtMostEnergyConsuming.setColumns(10);
		
		txtMostEnergyConsuming_1 = new JTextField();
		Iterator<Entry<Double, String>> i = MainPrg.stJoes.getApplianceConsumption().entrySet().iterator();
		Entry<Double, String> e = i.next();
		txtMostEnergyConsuming_1.setText("Most Energy Consuming Appliance: "+e.getValue()+" "+ e.getKey());
		Analytics.add(txtMostEnergyConsuming_1, "cell 0 2,growx");
		txtMostEnergyConsuming_1.setColumns(10);
		
		txtSchoolDailyEnergy = new JTextField();
		txtSchoolDailyEnergy.setText("School Daily Energy Cost: $"+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption()));
		Analytics.add(txtSchoolDailyEnergy, "cell 0 3,growx");
		txtSchoolDailyEnergy.setColumns(10);
		
		txtSchoolMonthlyEnergy = new JTextField();
		txtSchoolMonthlyEnergy.setText("School Monthly Energy Cost: $"+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption()*22));
		Analytics.add(txtSchoolMonthlyEnergy, "cell 0 4,growx");
		txtSchoolMonthlyEnergy.setColumns(10);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		list = new JList(model);
		model.addElement(e.getValue()+"  "+e.getKey());
		while(i.hasNext()){
			Entry<Double, String> ent = i.next();
			model.addElement(ent.getValue()+" "+ent.getKey());
		}
		Analytics.add(list, "flowx,cell 0 6,grow");
		
		btnViewGraph = new JButton("View Graph");
		Analytics.add(btnViewGraph, "cell 0 6");
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
