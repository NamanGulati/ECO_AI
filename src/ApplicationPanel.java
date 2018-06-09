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
		//super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();

		add(tabbedPane);



		for(int i=0;i<MainPrg.stJoes.getFloors().size();i++){
			JPanel floor1 = new JPanel();
			tabbedPane.addTab(("Floor"+i), null, floor1, null);

			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			FormLayout fl = new FormLayout(new ColumnSpec[] {
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("150px"),
					FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("155px"),},
					new RowSpec[] {
							FormSpecs.RELATED_GAP_ROWSPEC,
							RowSpec.decode("20px"),
							FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
							RowSpec.decode("20px"),
							FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
							RowSpec.decode("20px"),
							FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
							RowSpec.decode("20px"),
							FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
							RowSpec.decode("20px"),
							RowSpec.decode("33px"),
							RowSpec.decode("46px"),
							FormSpecs.UNRELATED_GAP_ROWSPEC,
							RowSpec.decode("75px"),});
			floor1.setLayout(fl);
			int row=2;
			int col=2;
			for(int j=0;j<MainPrg.stJoes.getFloors().get(i).getClassrooms().size();j++){
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
				System.out.println("Row Count: "+fl.getRowCount()+" Row: "+row+" Col: "+col);
				if(row>14){
					row=2;
					col+=2;
				}
				if(col>4){
					col=2;
					row=2;
				}
				try{
					floor1.add(btn, (""+row+", "+col));
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Error at:"+" Row: "+row+" Col: "+col);
					break;
				}
			
				
				//col+=2;
				row+=2;
			}
		}

		JPanel Analytics = new JPanel();
		tabbedPane.addTab("Analytics", null, Analytics, null);
		Analytics.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("280px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("155px"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						RowSpec.decode("33px"),
						RowSpec.decode("46px"),
						FormSpecs.UNRELATED_GAP_ROWSPEC,
						RowSpec.decode("75px"),}));

		txtDailySchoolConsumption = new JTextField();
		txtDailySchoolConsumption.setText("Daily School Consumption: "+MainPrg.stJoes.calcSchoolConsumption()+"kWh");
		Analytics.add(txtDailySchoolConsumption, "2, 2, 3, 1, fill, top");
		txtDailySchoolConsumption.setColumns(10);

		txtMostEnergyConsuming = new JTextField();
		txtMostEnergyConsuming.setText("Most Energy Consuming Classroom: "+MainPrg.stJoes.findMaxClassroom());
		Analytics.add(txtMostEnergyConsuming, "2, 4, 3, 1, fill, top");
		txtMostEnergyConsuming.setColumns(10);

		txtMostEnergyConsuming_1 = new JTextField();
		Iterator<Entry<Double, String>> i = MainPrg.stJoes.getApplianceConsumption().entrySet().iterator();
		Entry<Double, String> e = i.next();
		txtMostEnergyConsuming_1.setText("Most Energy Consuming Appliance: "+e.getValue()+" "+ e.getKey());
		Analytics.add(txtMostEnergyConsuming_1, "2, 6, 3, 1, fill, top");
		txtMostEnergyConsuming_1.setColumns(10);

		txtSchoolDailyEnergy = new JTextField();
		txtSchoolDailyEnergy.setText("School Daily Energy Cost: $"+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption()));
		Analytics.add(txtSchoolDailyEnergy, "2, 8, 3, 1, fill, top");
		txtSchoolDailyEnergy.setColumns(10);

		txtSchoolMonthlyEnergy = new JTextField();
		txtSchoolMonthlyEnergy.setText("School Monthly Energy Cost: $"+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption()*22));
		Analytics.add(txtSchoolMonthlyEnergy, "2, 10, 3, 1, fill, top");
		txtSchoolMonthlyEnergy.setColumns(10);

		DefaultListModel<String> model = new DefaultListModel<>();
		list = new JList(model);
		model.addElement(e.getValue()+"  "+e.getKey());
		while(i.hasNext()){
			Entry<Double, String> ent = i.next();
			model.addElement(ent.getValue()+" "+ent.getKey());
		}
		Analytics.add(list, "2, 12, 1, 3, fill, fill");

		btnViewGraph = new JButton("View Graph of Aplliances");
		btnViewGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenBarGraph.run(true);
			}
		});
		Analytics.add(btnViewGraph, "4, 12, fill, fill");

		JButton button = new JButton("View Graph of Clasrooms");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenBarGraph.run(false);
			}
		});
		Analytics.add(button, "2, 14, 3, 1, right, top");
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

	public static void run() {
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
