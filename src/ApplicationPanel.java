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
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import SortingAlgorithms.BubbleSort;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * @author Naman G
 * @date 6/13/18
 * 
 * Builds the main apllication interface
 */
public class ApplicationPanel extends JPanel {
	private JTextField txtDailySchoolConsumption;
	private JTextField txtMostEnergyConsuming;
	private JTextField txtMostEnergyConsuming_1;
	private JTextField txtSchoolDailyEnergy;
	private JTextField txtSchoolMonthlyEnergy;
	private JList list;
	private JButton btnViewGraph;
	private JPanel panel;
	private JButton btnNewButton;

	//Constructor - builds the display pannel
	public ApplicationPanel() {
		//super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();

		add(tabbedPane);



		for(int i=0;i<MainPrg.stJoes.getFloors().size();i++){
			JPanel floor1 = new JPanel();
			tabbedPane.addTab(("Floor"+MainPrg.stJoes.getFloors().get(i).getFloorNumber()), null, floor1, null);

			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
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
				//System.out.println("Room Number: "+MainPrg.stJoes.getFloors().get(i).getClassrooms().get(j).getName()+" Row Count: "+fl.getRowCount()+" Row: "+row+" Col: "+col);
				if(row>fl.getRowCount()){
					row=2;
					col+=2;
				}
				if(col>fl.getColumnCount()){
					col=2;
					row=2;
				}
				try{
					//System.out.println("2 Row Count: "+fl.getRowCount()+" Row: "+row+" Col: "+col);
					floor1.add(btn, (""+ col+", "+row));
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
				RowSpec.decode("20px"),
				RowSpec.decode("46px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("75px"),}));

		txtDailySchoolConsumption = new JTextField();
		txtDailySchoolConsumption.setToolTipText("This is the amount of energy the school consumes in a day");
		txtDailySchoolConsumption.setText("Daily School Consumption: "+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption())+"kWh");
		Analytics.add(txtDailySchoolConsumption, "2, 2, 3, 1, fill, top");
		txtDailySchoolConsumption.setColumns(10);

		txtMostEnergyConsuming = new JTextField();
		txtMostEnergyConsuming.setToolTipText("This is the room in the school that consumes the most energy");
		txtMostEnergyConsuming.setText("Most Energy Consuming Classroom: "+MainPrg.stJoes.findMaxClassroom());
		Analytics.add(txtMostEnergyConsuming, "2, 4, 3, 1, fill, top");
		txtMostEnergyConsuming.setColumns(10);

		txtMostEnergyConsuming_1 = new JTextField();
		txtMostEnergyConsuming_1.setToolTipText("This is the type of appliance that consumes the most energy in the school");
		MainPrg.stJoes.populateApplianceType();
		Double[]arr = new Double[MainPrg.stJoes.getApplianceConsumption().size()];
		MainPrg.stJoes.getApplianceConsumption().keySet().toArray(arr);
		Arrays.sort(arr);
		ArrayList<Double>keys= new ArrayList<Double>();
		for(int i=0;i<arr.length;i++){
			keys.add(arr[i]);
		}
		BubbleSort.sort(keys, false);
		txtMostEnergyConsuming_1.setText("Most Energy Consuming Appliance: "+MainPrg.stJoes.getApplianceConsumption().get(keys.get(0))+" "+ String.format("%.2f",keys.get(0)));
		Analytics.add(txtMostEnergyConsuming_1, "2, 6, 3, 1, fill, top");
		txtMostEnergyConsuming_1.setColumns(10);

		txtSchoolDailyEnergy = new JTextField();
		txtSchoolDailyEnergy.setToolTipText("This is how much the school must pay each day for electricity, based on the data");
		txtSchoolDailyEnergy.setText("School Daily Energy Cost: $"+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption()));
		Analytics.add(txtSchoolDailyEnergy, "2, 8, 3, 1, fill, top");
		txtSchoolDailyEnergy.setColumns(10);

		txtSchoolMonthlyEnergy = new JTextField();
		txtSchoolMonthlyEnergy.setToolTipText("This is how much the school must pay each month for electricity based on the data");
		txtSchoolMonthlyEnergy.setText("School Monthly Energy Cost: $"+String.format("%.2f",MainPrg.stJoes.calcSchoolConsumption()*22));
		Analytics.add(txtSchoolMonthlyEnergy, "2, 10, 3, 1, fill, top");
		txtSchoolMonthlyEnergy.setColumns(10);

		DefaultListModel<String> model = new DefaultListModel<>();
		list = new JList(model);
		list.setToolTipText("List of appliance types in the school, and their daily consumption");
		for(int i=0;i<keys.size();i++){
			model.addElement(MainPrg.stJoes.getApplianceConsumption().get(keys.get(i))+": "+String.format("%.2f", keys.get(i))+"kWh");
		}
		Analytics.add(list, "2, 12, 1, 3, fill, fill");
		btnViewGraph = new JButton("Applliance  Graph");
		btnViewGraph.setToolTipText("Shows a graph of the appliances types in the school(IF YOU HAVE ALREADY PRESSED EITHER BUTTON, YOU MUST RESTART THE PROGRAM TO VIEW THE GRAPH)");
		GenBarGraph graph= new GenBarGraph();
		btnViewGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(graph.st==null)
					graph.run();
				else
					graph.start(graph.st);
				try {
					graph.stop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Analytics.add(btnViewGraph, "4, 12, fill, fill");

		JButton button = new JButton("Classroom Graph");
		button.setToolTipText("Shows a graph of the 20 most energy consuming classrooms in the school(IF YOU HAVE ALREADY PRESSED EITHER BUTTON, YOU MUST RESTART THE PROGRAM TO VIEW THE GRAPH)");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenClassGraph.run();
				
			}
		});
		Analytics.add(button, "4, 14, right, top");
		
	}



	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: creates and shows gui
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("ECO_AI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add content to the window.
		frame.getContentPane().add(new ApplicationPanel(), BorderLayout.CENTER);

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
	public static void run() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
