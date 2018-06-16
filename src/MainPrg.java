import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gula1
 * @date 6/13/18
 * 
 * Reads input from the file and runs the gui
 *
 */
public class MainPrg {

	static School stJoes;

	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Reads the file, and builds the school object
	 */
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
				fl.sortList();
				floors.add(fl);
			}
			stJoes.setFloors(floors);
		}
	}
	public static void WriteFile() throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("dataNew.txt"));
		for(int i=0;i<stJoes.getFloors().size();i++){
			pw.println("#");
			pw.println(stJoes.getFloors().get(i).getFloorNumber());
			for(int j=0;j<stJoes.getFloors().get(i).getClassrooms().size();j++){
				//if(stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().size()>0){
				pw.println(stJoes.getFloors().get(i).getClassrooms().get(j).getName());
				pw.println("*");
				for(int k=0;k<stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().size();k++)
					pw.println(stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().get(k).getName()+","+stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().get(k).getHourlyConsumption()+","+stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().get(k).getQuantity()+","+stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().get(k).getTimeOn()+","+stJoes.getFloors().get(i).getClassrooms().get(j).getAppliances().get(k).getType());
				pw.println("*");
				//}
			}
		}
		pw.close();
	}

	/**
	 * @author Naman G
	 * @date Jun 13, 2018
	 * @param 
	 * @return void
	 * 
	 * Description: runs readFile() and runs the gui
	 */
	public static void main(String[]args) throws FileNotFoundException{
		try{
			stJoes=new School();
			readFile();
			stJoes.populateApplianceType();
			ApplicationPanel.run();
		}finally{
			WriteFile();
		}
	}
}
