import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.application.Application;
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
 *	Generates the graph to compare by classroom
 */
public class GenClassGraph extends Application {
	    
	    /* 
	     * @author Naman G
	     * @date 6/13/18
	     * @param Stage stage
	     * @return void
	     * 
	     *  place all plot points for each classroom
	     */
	    @SuppressWarnings("unchecked")
		@Override public void start(Stage stage) {
	    	XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Energy Consumption");
	        final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final BarChart<String,Number> bc = 
	            new BarChart<String,Number>(xAxis,yAxis);
	    
	    		ArrayList<Classroom>rooms=new ArrayList<Classroom>();
	    		for(int i=0;i<MainPrg.stJoes.getFloors().size();i++){
	    			for(int j=0;j<MainPrg.stJoes.getFloors().get(i).getClassrooms().size();j++){
	    				rooms.add(MainPrg.stJoes.getFloors().get(i).getClassrooms().get(j));
	    			}
	    		}
	    		sort(rooms);
	    		
	    		bc.setTitle("Energy Consumption by Clasroom");
		        xAxis.setLabel("Room");       
		        yAxis.setLabel("Consumption (kWh)");
		        System.out.println(rooms.size());
		        for(int i=0;i<20;i++){
		        	System.out.printf("%s   %f\n",rooms.get(i).getName(),rooms.get(i).calcClassConsumption());
		        	series1.getData().add(new XYChart.Data(rooms.get(i).getName(),rooms.get(i).calcClassConsumption()));
		        }
		        
		       
	        
	        
	        
	        Scene scene  = new Scene(bc,800,600);
	        bc.getData().addAll(series1);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	    /**
	     * @author Naman G
	     * @date Jun 13, 2018
	     * @param 
	     * @return void
	     * 
	     * Description: runs the graph
	     */
	    public static void run() {
	    	
	        launch(new String[0]);
	    }
	    /**
	     * @author Naman G
	     * @date Jun 13, 2018
	     * @param ArrayList<Classroom>rooms
	     * @return void
	     * 
	     * Description: sort list of classrooms by consumption
	     */
	    public static void sort(ArrayList<Classroom>rooms){
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
}
