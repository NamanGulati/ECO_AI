import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import SearchAlgorithms.LinearSearch;

public class School {
	//Class Variables
	private ArrayList<Floor> floors;
	private Map<Double,String> applianceConsumption;



	public School(ArrayList<Floor> floors) {
		this.floors = floors;
		applianceConsumption= new TreeMap<Double,String>();
	}


	public School() {
		// TODO Auto-generated constructor stub
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
					if (floors.get(floor).getClassrooms().get(rooms).getAppliances().get(applianceTypeIndex).equals(appliance)) {
						wattage+=(floors.get(floor).getClassrooms().get(rooms).getAppliances().get(applianceTypeIndex).calcDailyConsumption());      
					}        
				}      
			}
		}
		return wattage;
	} 
	
	/* ***************************
	 * Author: Jianying Chiang    Date: 2018-06-08
	 * Calculates and return the appliance type with 
	 * the most energy consumption type of
	 * St. Joseph Secondary School.
	 * @param: none
	 * @return: ApplianceType
	 * ****************************/
	public void populateApplianceType() {
		ArrayList<String>applianceTypes=new ArrayList<String>();
		for(int i=0;i<floors.size();i++){
			for(int j=0;j<floors.get(i).getClassrooms().size();j++){
				for(int k=0;k<floors.get(i).getClassrooms().get(k).getAppliances().size();k++){
					if(!LinearSearch.search(applianceTypes,floors.get(i).getClassrooms().get(k).getAppliances().get(k).type,"type")){
						applianceTypes.add(floors.get(i).getClassrooms().get(k).getAppliances().get(k).type);
						this.applianceConsumption.put(calcApplianceTotal(floors.get(i).getClassrooms().get(k).getAppliances().get(k).type), floors.get(i).getClassrooms().get(k).getAppliances().get(k).type);
					}
				}

			}
		}


	}

	/* ***************************
	 * Author: Jianying Chiang    Date: 2018-06-08
	 * Calculates and return the classroom with the 
	 * largest energy consumption of 
	 * St. Joseph Secondary School.
	 * @param: Classroom
	 * @return: none
	 * ****************************/
	public Classroom findMaxClassroom() {
		if (floors.get(0).findMaxClassroom().calcClassConsumption() >= floors.get(1).findMaxClassroom().calcClassConsumption() &&
				floors.get(0).findMaxClassroom().calcClassConsumption() >= floors.get(2).findMaxClassroom().calcClassConsumption()) {
			return floors.get(0).findMaxClassroom();
		}
		else if (floors.get(1).findMaxClassroom().calcClassConsumption() >= floors.get(0).findMaxClassroom().calcClassConsumption() &&
				floors.get(1).findMaxClassroom().calcClassConsumption() >= floors.get(2).findMaxClassroom().calcClassConsumption()) {
			return floors.get(1).findMaxClassroom();    
		}
		else if (floors.get(2).findMaxClassroom().calcClassConsumption() >= floors.get(0).findMaxClassroom().calcClassConsumption() &&
				floors.get(2).findMaxClassroom().calcClassConsumption() >= floors.get(1).findMaxClassroom().calcClassConsumption()) {
			return floors.get(2).findMaxClassroom();    
		}
		else {return null;}
	} 
	
	public Classroom getClassroom(String roomName){
		for(int i=0;i<floors.size();i++){
			for(int j=0;j<floors.get(i).getClassrooms().size();i++){
				if(roomName.equals(floors.get(i).getClassrooms().get(j).getName())){
					return floors.get(i).getClassrooms().get(j);
				}
			}
		}
		return null;
	}
	
	public double calcPrice(){
		return this.calcSchoolConsumption()*0.094;
	}
	public static double calcTrees(double consumption){
		return consumption/12;
	}
}
