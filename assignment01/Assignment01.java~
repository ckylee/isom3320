import java.util.*;
import java.io.*;
import java.text.*;

public class Assignment01 {
  public static void main(String[] args) throws Exception{
    
    File file = new File("test.txt");     // define a File object
    Scanner scanner = new Scanner(file);  // define a Scanner object to read the file
    String line;

    // write a loop to read the file "test.txt" line by line
    // then output the the screen
    int i = 0;
    double overallTotal = 0;
    
    //first line
    line = scanner.nextLine();
    String[] splitarr = line.split(",");
    double[] totalScores = new double[splitarr.length];
    double[] percentages = new double[splitarr.length];
    System.out.printf("%-9s %-19s", "ID", "Name");
    
    //set totalScores and percentages to empty (0) array
    for (int e = 0; e < splitarr.length; e++) {
      totalScores[e] = 0;
      percentages[e] = 0;
    }
    
    //print heading
    for (int j = 2; j < splitarr.length; j+=2) {
          System.out.printf("%-9s", splitarr[j]);
    }
    
    //percentages
    int count = 0;
    for (int p = 3; p < splitarr.length; p+=2){
      count++;
      percentages[p-count] = Double.parseDouble(splitarr[p]) * 0.01;
    }
    
    System.out.println("Overall");
    
    
    //read rest of the lines
    while(scanner.hasNextLine()){
      i++;
      double overallIndividual = 0;
     
      line = scanner.nextLine();
      String[] splitarr2 = line.split(",");
      System.out.printf("%-8s %-20s", splitarr2[0], splitarr2[1]);
      
      for(int k = 2; k < splitarr2.length; k++) {
        //add total for each category as you print individual category scores
        System.out.printf("%-9s", splitarr2[k]);
        totalScores[k] = totalScores[k] + Double.parseDouble(splitarr2[k]);
        
      //overall scores
       overallIndividual = overallIndividual + ((Double.parseDouble(splitarr2[k])) * percentages[k]);
      }
      
      overallTotal += overallIndividual; //add to overallTotal for avg calculation
      System.out.printf("%-9.2f", overallIndividual);

      //next person
      System.out.println("");

    }
    
    //average
    System.out.printf("%-20s %-8s", "", "Average: ");
    totalScores[(totalScores.length / 2) +1] = overallTotal;
    for(int avg = 2; avg < (totalScores.length / 2) + 2; avg++) {
      double average = totalScores[avg] / i;
      System.out.printf("%-9.2f", average);
    }
    
    scanner.close();
  }
}