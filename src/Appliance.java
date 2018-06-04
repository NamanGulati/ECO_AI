/* @Author: Cedric Tordecilla @Date: 6/3/2018
 * This class handles the various Appliances within
 * the school. This includes the name and quantity,
 * along with the amount of energy consumed.*/
public class Appliance {
  private String name;
  private int quantity;
  //private ApplianceType type;
  private double hourlyConsumption;
  private double timeOn;
  private double dailyConsumption;
  
  //Default Constructor
  Appliance() {}
  
  //add get/set methods
  public String getName() {return name;}
  public int getQuantity() {return quantity;}
  
  public double calcDailyConsumption() {
    dailyConsumption=hourlyConsumption*timeOn;
    return dailyConsumption;
  }
    
  
}
