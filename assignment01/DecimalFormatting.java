import java.text.*;

public class DecimalFormatting {
  
  public static void main(String[] args) throws Exception {
    System.out.println("Unformatted PI = " + Math.PI);
    
    DecimalFormat myFormatter = new DecimalFormat("#.00");
    String formattedString = myFormatter.format(Math.PI);
    System.out.println("Formatted PI = " + formattedString);
  }
}