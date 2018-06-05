import java.util.ArrayList;

public class Floor {
	private int floorNumber;
	private ArrayList<Classroom>classrooms;
	
	public Floor(int floorNumber, ArrayList<Classroom> classrooms) {
		this.floorNumber = floorNumber;
		this.classrooms = classrooms;
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
	public Classroom findMaxClassroom(){
		return classrooms.get(0);
	}

	public double calcFloorConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
