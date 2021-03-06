import java.util.*;
import java.io.*;

public class ReadStringFromFileLineByLine {
  
  public static void main(String[] args) throws Exception {
    File file = new File("test.txt");     // define a File object
    Scanner scanner = new Scanner(file);  // define a Scanner object to read the file
    String line;
    
    // write a loop to read the file "test.txt" line by line
    // then output the the screen
    int i = 0;
    while(scanner.hasNextLine()){
      i++;
      line = scanner.nextLine();   // read a line in the file, and store into variable "line"
      String[] arr = line.split(",");
    }
    System.out.println("Total number of lines :  " + i);
    
    scanner.close();
  }
}