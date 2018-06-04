import java.util.ArrayList;

public class Classroom {

	private String name;
	private ArrayList <Appliance> Appliances;
	private String department;
	
	public Classroom(String name, ArrayList<Appliance> appliances, String department) {
		this.name = name;
		Appliances = appliances;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Appliance> getAppliances() {
		return Appliances;
	}

	public void setAppliances(ArrayList<Appliance> appliances) {
		Appliances = appliances;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
