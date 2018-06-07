import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPrg {
	static School stJoes;
	public static void readFile() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("data.txt"));
		while(scan.hasNext()){
			if(scan.nextLine().equals("_")){
				while(!scan.nextLine().equals("_")){
					String roomNumber=scan.nextLine();
					scan.nextLine();
					ArrayList<Appliance>appliances= new ArrayList<Appliance>();
					while(!scan.nextLine().equals("*")){
						Scanner input= new Scanner(scan.nextLine());
						input.useDelimiter(",");
						appliances.add(new Appliance(input.next(),))
					}
				}
			}
		}
	}
}
