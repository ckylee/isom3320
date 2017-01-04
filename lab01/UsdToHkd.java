import java.util.Scanner;

public class UsdToHkd {
  public static void main(String[] args) {
    double USD, HKD;
    Scanner scanner = new Scanner(System.in);
    String input = "";
    
    System.out.println("Enter USD: ");
    
    input = scanner.nextLine();
    
    USD = Double.parseDouble(input);
    HKD = USD * 7.7807;
    
    System.out.println(input + " USD = " + HKD + " HKD");    
  }
}