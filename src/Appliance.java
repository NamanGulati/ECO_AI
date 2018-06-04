/* @Author: Cedric Tordecilla @Date: 6/3/2018
 * This class handles the various Appliances within
 * the school. This includes the name and quantity,
 * along with the amount of energy consumed.*/
public class Appliance {
	private String name;
	private int quantity;
	private ApplianceType type;
	private double hourlyConsumption;
	private double timeOn;
	private double dailyConsumption;





	public Appliance(String name, int quantity, ApplianceType type, double hourlyConsumption, double timeOn,
			double dailyConsumption) {
		this.name = name;
		this.quantity = quantity;
		this.type = type;
		this.hourlyConsumption = hourlyConsumption;
		this.timeOn = timeOn;
		this.dailyConsumption = dailyConsumption;
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





	public ApplianceType getType() {
		return type;
	}





	public void setType(ApplianceType type) {
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





	public double getDailyConsumption() {
		return dailyConsumption;
	}





	public void setDailyConsumption(double dailyConsumption) {
		this.dailyConsumption = dailyConsumption;
	}





	public double calcDailyConsumption() {
		dailyConsumption=hourlyConsumption*timeOn;
		return dailyConsumption;
	}


}
