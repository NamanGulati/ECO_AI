import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPrg {
	static School stJoes;
	public static void readFile() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("data.txt"));
		if(scan.hasNextLine()&&scan.nextLine().equals("#")){
			ArrayList<Floor>floors=new ArrayList<Floor>();
			while(scan.hasNext()){
				Floor fl=new Floor();
				fl.setFloorNumber(scan.nextInt());
				scan.nextLine(); //clear buffer
				ArrayList<Classroom>rooms=new ArrayList<Classroom>();
				String read = scan.nextLine();
				while(!read.equals("#")){
					Classroom cl = new Classroom();
					cl.setName(read);
					System.out.println("Room Numpber: "+cl.getName());
					scan.nextLine();					//Jump over *
					ArrayList<Appliance>appliances= new ArrayList<Appliance>();
					String str=scan.nextLine();
					//System.out.println("Str");
					while(!str.equals("*")){
						Appliance appl = new Appliance();
						Scanner input= new Scanner(str);
						input.useDelimiter(",");
						appl.setName(input.next());
						appl.setHourlyConsumption(input.nextDouble());
						appl.setQuantity(input.nextInt());
						appl.setTimeOn(input.nextDouble());
						appl.setType(input.next());
						appliances.add(appl);
						System.out.println(appl);
						str=scan.nextLine();
					}
					cl.setAppliances(appliances);
					rooms.add(cl);
					if(scan.hasNext())
						read=scan.nextLine();
					else
						break;
				}
				fl.setClassrooms(rooms);
				floors.add(fl);
			}
			stJoes.setFloors(floors);
		}
	}

	public static void main(String[]args) throws FileNotFoundException{
		stJoes=new School();
		readFile();
		stJoes.populateApplianceType();
		ApplicationPanel.run();
	}
}
