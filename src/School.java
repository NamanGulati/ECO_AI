import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Naman Gulati and JY
 * @date 6/13/18
 * 
 * Holds energy data for entire school
 */
public class School {
	//Class Variables
	private ArrayList<Floor> floors;
	private Map<Double,String> applianceConsumption;



	public School(ArrayList<Floor> floors) {
		this.floors = floors;
		applianceConsumption= new HashMap<Double,String>();
	}


	public School() {
		// TODO Auto-generated constructor stub
		applianceConsumption= new TreeMap<Double,String>();
	}


	public Map<Double, String> getApplianceConsumption() {
		return applianceConsumption;
	}


	public void setApplianceConsumption(Map<Double, String> applianceConsumption) {
		this.applianceConsumption = applianceConsumption;
	}


	public ArrayList<Floor> getFloors() {
		return floors;
	}


	public void setFloors(ArrayList<Floor> floors) {
		this.floors = floors;
	}


	/* ***************************
	 * Author: Jianying Chiang    Date: 2018-06-08
	 * Calculates and returns the total energy 
	 * consumption of St. Joseph Secondary School.
	 * @param: none
	 * @return: double
	 * ****************************/
	public double calcSchoolConsumption() {
		double schoolEnergyUse=0.00;
		for (int x=0; x<floors.size(); x++) {
			schoolEnergyUse += floors.get(x).calcFloorConsumption();    
		}
		return schoolEnergyUse;
	} 
	
	/* ***************************
	 * Author: Jianying Chiang    Date: 2018-06-08
	 * Calculates and returns the sum of the 
	 * consumption for all the appliances of the 
	 * specified type of St. Joseph Secondary School.
	 * @param: ApplianceType
	 * @return: double
	 * ****************************/
	public double calcApplianceTotal(String appliance) {
		double wattage=0;
		for (int floor=0; floor<floors.size(); floor++) {
			for (int rooms=0; rooms<floors.get(floor).getClassrooms().size(); rooms++) {
				for (int applianceTypeIndex=0; applianceTypeIndex<floors.get(floor).getClassrooms().get(rooms).getAppliances().size(); applianceTypeIndex++) {
					if (floors.get(floor).getClassrooms().get(rooms).getAppliances().get(applianceTypeIndex).getType().equalsIgnoreCase(appliance)) {
						wattage+=(floors.get(floor).getClassrooms().get(rooms).getAppliances().get(applianceTypeIndex).calcDailyConsumption());      
					}        
				}      
			}
		}
		return wattage;
	} 
	

	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: populates the Map by finding the various types of appliances and the consumption of each type
	 */
	public void populateApplianceType() {
		ArrayList<String>applianceTypes=new ArrayList<String>();
		for(int i=0;i<floors.size();i++){
			for(int j=0;j<floors.get(i).getClassrooms().size();j++){
				for(int k=0;k<floors.get(i).getClassrooms().get(j).getAppliances().size();k++){
					Appliance temp=this.floors.get(i).getClassrooms().get(j).getAppliances().get(k);
					if(!applianceTypes.contains(temp.getType())){
						applianceTypes.add(temp.getType());
						System.out.println("Floor: "+floors.get(i).getFloorNumber()+" Room: "+floors.get(i).getClassrooms().get(j).getName()+" Appliance: "+floors.get(i).getClassrooms().get(j).getAppliances().get(k));
						this.applianceConsumption.put(calcApplianceTotal(temp.getType()), temp.getType().toUpperCase());
					}
				}

			}
		}

		for(int i=0;i<applianceTypes.size();i++){
			System.out.println(applianceTypes.get(i));
		}
	}

	/* ***************************
	 * Author: Naman Gulati    Date: 2018-06-08
	 * Calculates and return the classroom with the 
	 * largest energy consumption of 
	 * St. Joseph Secondary School.
	 * @param: Classroom
	 * @return: none
	 * ****************************/
	public Classroom findMaxClassroom() {
		double max=floors.get(0).getClassrooms().get(0).calcClassConsumption();
		Classroom cl=floors.get(0).getClassrooms().get(0);
		for(int i=0;i<floors.size();i++){
			for(int j=0;j<floors.get(i).getClassrooms().size();j++){
				if(floors.get(i).getClassrooms().get(j).calcClassConsumption()>max){
					max=floors.get(i).getClassrooms().get(j).calcClassConsumption();
					cl=floors.get(i).getClassrooms().get(j);
				}
			}
		}
		return cl;
	} 
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param String
	 * @return Classroom
	 * 
	 * Description: returns the clasroom with the matching room name
	 */
	public Classroom getClassroom(String roomName){
		for(int i=0;i<floors.size();i++){
			for(int j=0;j<floors.get(i).getClassrooms().size();j++){
				if(roomName.equals(floors.get(i).getClassrooms().get(j).getName())){
					return floors.get(i).getClassrooms().get(j);
				}
			}
		}
		return null;
	}
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return double
	 * 
	 * Description: calculates the cost of energy for the whole school
	 */
	public double calcPrice(){
		return this.calcSchoolConsumption()*Constants.ENERGY_RATE;
	}
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param double
	 * @return double
	 * 
	 * Description: returns the number of trees based on the wattage
	 */
	public static double calcTrees(double consumption){
		return consumption/12;
	}
}
