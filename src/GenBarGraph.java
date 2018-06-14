import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import SortingAlgorithms.BubbleSort;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * @author Naman G
 * @date 6/13/18
 *
 * generates the bar graph, comparing the top 20 appliances
 */
public class GenBarGraph extends Application{

	public static Stage st;

	/*
	 * @author: Naman G
	 * @date: 6/13/18
	 * @param Stage
	 * @return void
	 * 
	 * Description: generates the graph, and adds all of the plot points
	 */
	@SuppressWarnings("unchecked")
	@Override 
	public void start(Stage stage) {
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Energy Consumption");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String,Number> bc = 
				new BarChart<String,Number>(xAxis,yAxis);

		Iterator<Entry<Double, String>> i = MainPrg.stJoes.getApplianceConsumption().entrySet().iterator();

		stage.setTitle("Most Energy Consuming Appliances");

		bc.setTitle("Most Energy Consuming Appliances");
		xAxis.setLabel("Appliance");       
		yAxis.setLabel("Consumption (kWh)");
		while(i.hasNext()){
			Entry<Double, String> e = i.next();
			series1.getData().add(new XYChart.Data(e.getValue(), e.getKey()));		       
		}






		Scene scene  = new Scene(bc,800,600);
		bc.getData().addAll(series1);
		stage.setScene(scene);
		st=stage;
		stage.show();
	}
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param ArrayList<Classroom> rooms
	 * @return void
	 * 
	 * Description: sorts the list by class consumptions
	 */
	public void sort(ArrayList<Classroom>rooms){
		for(int i=0;i<rooms.size();i++){
			for(int j=1;j<(rooms.size()-i);j++){
				if(rooms.get(j).calcClassConsumption()>rooms.get(j-1).calcClassConsumption()){
					Classroom cl=rooms.get(j);
					rooms.set(j, rooms.get(j-1));
					rooms.set(j-1, cl);
				}
			}
		}
	}
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: runs the graph
	 */
	public void run() {
		if(st==null)
			launch(null);
		else
			start(st);
		
	}

}
