import java.util.ArrayList;

import SortingAlgorithms.BubbleSort;

/**
 * @author Naman G
 * @date 6/13/18
 * 
 * Holds the consumption data for the floor
 */
public class Floor {
	private int floorNumber;
	private ArrayList<Classroom>classrooms;

	public Floor(int floorNumber, ArrayList<Classroom> classrooms) {
		this.floorNumber = floorNumber;
		this.classrooms = classrooms;
	}

	public Floor() {
		// TODO Auto-generated constructor stub
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public ArrayList<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(ArrayList<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return Classroom
	 * 
	 * Description: finds the classroom on the floor which draws the most energy
	 */
	public Classroom findMaxClassroom(){
		double max=classrooms.get(0).calcClassConsumption();
		Classroom cl=classrooms.get(0);
		for(int i =0;i<this.classrooms.size();i++){
			if(classrooms.get(i).calcClassConsumption()>max){
				max=classrooms.get(i).calcClassConsumption();
				cl=classrooms.get(i);
			}
		}
		return cl;
	}

	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return double
	 * 
	 * Description: calculates the total energy consumption for the entire floor
	 */
	public double calcFloorConsumption() {
		double sum=0;
		for(int i=0;i<classrooms.size();i++){
			sum+=classrooms.get(i).calcClassConsumption();
		}
		return sum;
	}
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return double
	 * 
	 * Description: calculates the energy cost for the floor
	 */
	public double calcPrice(){
		return calcFloorConsumption()*Constants.ENERGY_RATE;
	}
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: sorts the list of classrooms by name
	 */
	public void sortList(){
		BubbleSort.sort(this.classrooms, true, "name");
	}
}
