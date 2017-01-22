import java.util.*;
import java.io.*;
import java.text.*;


abstract class Student extends Course implements Comparable {
   private static String stuDataLength;
  
  // assignment 1 solution from Samuel ^^;; (modified some parts i.e NullPointer Exception) //
   public static void processStudents(){

    // for row 0, store in hdrStr, then split and store in hdrData[]
    // for the rest of file, append and store in tmpStr with suffix "###;###"
    for (int i=0; input.hasNextLine(); i++) {
      line = input.nextLine();
      if (i == 0) {  // header row
        hdrStr = line;
        hdrData = hdrStr.split(",");
        numOfAssessments = (hdrData.length - 2) / 2;   // -X-ID-X-, -X-Name-X-, Assessment1, weighting1, Assessment2, weighting2, ...
      }
      else {   // student data block
       tmpStr = tmpStr + line + separatorSymbol;
      }
    }
    
    // Split tmpStr by symbol "###;###", store in stuStr[]
    stuStr = tmpStr.split(separatorSymbol);
    numOfStudents = stuStr.length;
    
    // Split each row of student data, store in stuData[][]
    stuData = new String[numOfStudents][numOfAssessments+3]; //place for overall
    for (int i=0; i<numOfStudents; i++) {
      stuData[i] = stuStr[i].split(",");
      stuData[i] = Arrays.copyOf(stuData[i], stuData[i].length + 1);
      stuDataLength = Integer.toString(stuData[i].length);
    }
    
    
    assessments = new String[numOfAssessments];
    weightings  = new double[numOfAssessments];
    overall     = new double[numOfStudents];
    average     = new double[numOfAssessments];
    overallAvg  = 0;
    
    for (int i=2, j=0; i<hdrData.length; i+=2) {
      assessments[j] = hdrData[i].trim();
      weightings[j]  = Double.parseDouble(hdrData[i+1]);
      j++;
    }
    
    //throws NullPointer exception when student data is missing a column
    try{
      for (int i=0; i<numOfStudents; i++) {
        overall[i] = 0;
        for (int j=0; j<numOfAssessments; j++) {
          overall[i] += Double.parseDouble(stuData[i][j+2]) * weightings[j];
        }
        overall[i] /= 100;
        overallAvg += overall[i];
      }
    }
    catch(NullPointerException ex) {
       System.out.println("Looks like you forgot to fill in column(s) of student data!");
     }
    overallAvg /= numOfStudents;
    
    for (int j=0; j<numOfAssessments; j++) {
      average[j] = 0;
      for (int i=0; i<numOfStudents; i++) {
        average[j] += Double.parseDouble(stuData[i][j+2]);
      }
      average[j] /= numOfStudents;
    }
    
    //add overall[x] to stuData[x][last element], for easier printing
    for(int i=0; i < numOfStudents; i++) {
      stuData[i][Integer.parseInt(stuDataLength)-1] = Double.toString(overall[i]);
    }
    
    //sorting
    Arrays.sort(stuData, new Comparator<String[]>(){
      @Override
      public int compare(final String[] array1, final String[] array2){
        return Double.valueOf(array2[Integer.parseInt(stuDataLength)-1]).compareTo(
               Double.valueOf(array1[Integer.parseInt(stuDataLength)-1]));
      }
    });
    
    //increase average[] array size to add overallAvg, for easier printing
    average = Arrays.copyOf(average, average.length + 1);
    average[average.length-1] = overallAvg;

 }
 // assignment 1 solution from Samuel ^^;; (modified some parts i.e NullPointer Exception) //
  
     
  public static void printStudents(){
        
    // print header //
    System.out.printf("%-9s %-20s", "ID", "Name");
    for (int i=0; i < numOfAssessments; i++) {
      System.out.printf("%-10s", assessments[i]);
    }
    System.out.printf("%-9s %-10s\n", "Overall", "Rank");
    // print header // 
    
    // print students and rank //
        for (int i=0; i < numOfStudents; i++) {
          System.out.printf("%-8s %-21s", stuData[i][0], stuData[i][1]);
          for(int j = 2; j < numOfAssessments + 3; j++) {
            System.out.printf("%-10.2f", Double.parseDouble(stuData[i][j]));
          }
          System.out.printf("%-10s", i+1);
          System.out.println("");
    }
    // print students and rank //
        
    // print average //
    System.out.printf("%-20s %-9s", "", "Average:");
        for(int i=0; i < average.length; i++) {
          System.out.printf("%-10.2f", average[i]);
        }
    // print average //
  }
}
    