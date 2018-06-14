
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Done
/**
 * @author Naman Gulati
 * @date 6/13/2018
 * 
 * Holds the cosnumption data for the classroom
 */
public class Classroom {


	public String name;
	public ArrayList <Appliance> Appliances;
	public double consumption;
	
	//Constructors
	public Classroom(String name, ArrayList<Appliance> appliances) {
		this.name = name;
		Appliances = appliances;
		consumption=calcClassConsumption();
	}

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Get-set methods
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

	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return double
	 * 
	 * Description: Calculates the toal consumption for the entire classroom
	 */
	public double calcClassConsumption(){
		double sum=0;
		for(int i=0;i<Appliances.size();i++){
			sum+=Appliances.get(i).calcDailyConsumption();
		}
		this.consumption=sum;
		return sum;
	}
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return Map<String,Double>
	 * 
	 * Description: finds the appliance type witht the most energy consumption, returns its name and consumption
	 */
	public  Map<String, Double> findMaxApplianceType(){
		
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
	
	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return double
	 * 
	 * Description: Calculates the cost of energy for the class
	 */
	public double calcPrice(){
		return this.calcClassConsumption()*Constants.ENERGY_RATE;
	}
	
	/* @author Naman G
	 * @date 6/13/18
	 * @param
	 * @return String
	 * 
	 *  Returns a string describing the clasroom consumption
	 */
	public String toString(){
		return this.name+" "+String.format("%.2f",this.calcClassConsumption())+"kwh";
	}
	
}
