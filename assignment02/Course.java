import java.util.*;
import java.io.*;
import java.text.*;

//assignment 1 solution from Samuel ^^;;
public class Course{
  private static File file;
  public static Scanner input;
  public static String line = "";
  public static double[] totalScores, percentages;
  public static String hdrStr, hdrData[], stuStr[], stuData[][], assessments[];
  public static double weightings[], overall[], average[], overallAvg;
  public static String separatorSymbol = "###;###";
  public static String separatorOut = " ";
  public static int numOfStudents = 0, numOfAssessments = 0;
  public static String tmpStr = "";

  //load course info
  public static void load() throws Exception{
    
    // Get the file and open by Scanner
    file = new File("test.txt"); 
    input = new Scanner(file);
  }

}