/* @Author: Cedric Tordecilla @Date: 6/3/2018
 * This class handles the various Appliances within
 * the school. This includes the name and quantity,
 * along with the amount of energy consumed.*/

//CLASS FINISHED
public class Appliance {
	private String name;
	private int quantity;
	public String type;
	private double hourlyConsumption;
	private double timeOn;
	





	public Appliance(String name, int quantity, String type, double hourlyConsumption, double timeOn) {
		this.name = name;
		this.quantity = quantity;
		this.type = type;
		this.hourlyConsumption = hourlyConsumption;
		this.timeOn = timeOn;
		
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public double getHourlyConsumption() {
		return hourlyConsumption;
	}





	public void setHourlyConsumption(double hourlyConsumption) {
		this.hourlyConsumption = hourlyConsumption;
	}





	public double getTimeOn() {
		return timeOn;
	}





	public void setTimeOn(double timeOn) {
		this.timeOn = timeOn;
	}



	public double calcDailyConsumption() {
		return hourlyConsumption*timeOn*quantity;
	}


}
