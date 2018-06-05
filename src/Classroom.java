import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Done
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
	
	public double calcClassConsumption(){
		double sum=0;
		for(int i=0;i<Appliances.size();i++){
			sum+=Appliances.get(i).calcDailyConsumption();
		}
		return sum;
	}
	
	public Map<String, Double> findMaxApplianceType(){
		
		Map<String, Double> maxVal=new HashMap<String, Double>();
		double max=0;
		String type="";
		for(int i=0;i<Appliances.size();i++){
			if(Appliances.get(i).calcDailyConsumption()>max){
				max=Appliances.get(i).calcDailyConsumption();
				type=Appliances.get(i).getType();
			}
		}
		maxVal.put(type, max);
		return maxVal;
	}

}
