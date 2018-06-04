
public class School {
	//Class Variables
  private ArrayList<Floor> floors;
  //Constructor
  School() {
    floors = new ArrayList<Floor>(3);  
  }
  //Get-Set Methods
  //public void setFloor() {}
  public floors getFloor(int index) {return floors.get(index);}
  //Methods
  
/* ***************************
* Author: Jianying Chiang    Date: 2018-06-08
* Calculates and returns the total energy 
* consumption of St. Joseph Secondary School.
* @param: none
* @return: double
* ****************************/
  public double calcSchoolConsumption() {
    double schoolEnergyUse=0.00;
    for (int x=0; x<floors.length; x++) {
      schoolEnergyUse += floors.get(x).calcFloorConsumption;    
    }
    return schoolEnergyUse;
  } //----End of calcSchoolConsumption Method----
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
    for (int floor=0; floor<floors.length; floor++) {
      for (int rooms=0; rooms<floors.get(floor).classrooms.length; rooms++) {
        for (int applianceTypeIndex=0; applianceTypeIndex<floors.get(floor).classrooms.get(rooms).appliances.length; applianceTypeIndex++) {
          if (floors.get(floor).classrooms.get(rooms).appliances.get(applianceTypeIndex).equals(appliance)) {
            wattage+=(floors.get(floor).classrooms.get(rooms).appliances.get(applianceTypeIndex).calcDailyConsumption());      
          }        
        }      
      }
    }
    return wattage;
  } //------End of calcApplianceTotal Method------
/* ***************************
* Author: Jianying Chiang    Date: 2018-06-08
* Calculates and return the appliance type with 
* the most energy consumption type of
* St. Joseph Secondary School.
* @param: none
* @return: ApplianceType
* ****************************/
  public String findMaxApplianceType() {
    `    
    return 0;//ApplianceType  
  } //-----End of findMaxApplianceType Method-----

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
  } //-------End of findMaxClassroom Method-------
	public static Classroom getClassRoom(String roomName) {
		// TODO Auto-generated method stub
		return new Classroom();
	}

}
