import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class GenBarGraph extends Application{
	  final static String austria = "Austria";
	    final static String brazil = "Brazil";
	    final static String france = "France";
	    final static String italy = "Italy";
	    final static String usa = "USA";
	    private static boolean classOrAppliance=false;
	    
	    @Override public void start(Stage stage) {
	    	if(classOrAppliance){
	    		
	    		Iterator i = MainPrg.stJoes.getApplianceConsumption().entrySet().iterator();
	    		
	    		stage.setTitle("Most Energy Consuming Appliances");
		        final CategoryAxis xAxis = new CategoryAxis();
		        final NumberAxis yAxis = new NumberAxis();
		        final BarChart<String,Number> bc = 
		            new BarChart<String,Number>(xAxis,yAxis);
		        bc.setTitle("Country Summary");
		        xAxis.setLabel("Appliance");       
		        yAxis.setLabel("Consumption (kWh)");
		        ArrayList<XYChart.Series>series = new ArrayList<XYChart.Series>();
		        while(i.hasNext()){
		        	
		        	
		       
		        }
		        XYChart.Series series1 = new XYChart.Series();
		        series1.setName("2003");       
		        series1.getData().add(new XYChart.Data(austria, 25601.34));
		        series1.getData().add(new XYChart.Data(brazil, 20148.82));
		        series1.getData().add(new XYChart.Data(france, 10000));
		        series1.getData().add(new XYChart.Data(italy, 35407.15));
		        series1.getData().add(new XYChart.Data(usa, 12000));  
	    	}
	           
	        
	        
	        
	        Scene scene  = new Scene(bc,800,600);
	        bc.getData().addAll(series1, series2, series3);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	    public static void run(boolean selection) {
	    	classOrAppliance=selection;
	        launch(new String[0]);
	    }
}
