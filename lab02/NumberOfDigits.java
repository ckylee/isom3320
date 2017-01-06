import java.util.Scanner;

public class NumberOfDigits {
  public static void main(String[] args) {
    
    System.out.println("Enter an integer ");
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    
    String inputString = Integer.toString(input);
    
    System.out.println("Number of digits: " + inputString.length());
    
  }
}