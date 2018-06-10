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
					
					while(!str.equals("*")){
						Appliance appl = new Appliance();
						Scanner input= new Scanner(str);
						input.useDelimiter(",");
						appl.setName(input.next());
						appl.setHourlyConsumption(input.nextDouble());
						appl.setQuantity(input.nextInt());
						System.out.println(appl.getQuantity());
						appl.setTimeOn(input.nextDouble());
						String type=input.next();
						if(type.equals("light")||type.equals("lights"))
							appl.setType("light");
						else if(type.equals("computer")||type.equals("computers"))
							appl.setType("computers");
						else if(type.equals("kitchen")||type.equals("kitchen appliances")||type.equals("kitchen appliances "))
							appl.setType("kitchen appliances");
						else if(type.equals("electronics")||type.equals("electronics "))
							appl.setType("electronics");
						else
							appl.setType(type);
						appliances.add(appl);
						//System.out.println(appl);
						str=scan.nextLine();
					}
					cl.Appliances=appliances;
					rooms.add(cl);
					System.out.println(cl);
					for(int i=0;i<cl.getAppliances().size();i++){
						System.out.println(cl.getAppliances().get(i));
					}
					System.out.println("\n");
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
