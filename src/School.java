import java.io.*;
public class School {
  public static void main(String [] arg) {

    String fileName = "file.txt";
    String info = null;

    try {

      FileReader fr = new FileReader(fileName);
      
      BufferedReader br = new BufferedReader(fr);
      
      while((info = br.readLine()) != null) {
        System.out.println(info); //Outputs the information stored on file
      }       
      br.close();         
    }
    
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open '" + fileName + "': File not found.");                
    }
    
    catch(IOException ex) {
      System.out.println("Error reading '" + fileName + "'");                  
    }
  }

}
