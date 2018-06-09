import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Done
public class Classroom {


	private String name;
	private static ArrayList <Appliance> Appliances;
	double consumption;
	
	public Classroom(String name, ArrayList<Appliance> appliances) {
		this.name = name;
		Appliances = appliances;
		consumption=calcClassConsumption();
	}

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
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

	
	public double calcClassConsumption(){
		double sum=0;
		for(int i=0;i<Appliances.size();i++){
			sum+=Appliances.get(i).calcDailyConsumption();
		}
		this.consumption=sum;
		return sum;
	}
	
	public static Map<String, Double> findMaxApplianceType(){
		
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
	public double calcPrice(){
		return this.calcClassConsumption()*0.094;
	}
	public String toString(){
		return this.name+" "+this.calcClassConsumption()+"kwh";
	}
	
}
