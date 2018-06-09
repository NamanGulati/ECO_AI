import java.util.ArrayList;

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

	public double calcFloorConsumption() {
		double sum=0;
		for(int i=0;i<classrooms.size();i++){
			sum+=classrooms.get(i).calcClassConsumption();
		}
		return sum;
	}
	
	public double calcPrice(){
		return calcFloorConsumption()*0.094;
	}

}
