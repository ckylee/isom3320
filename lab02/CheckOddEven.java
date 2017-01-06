import java.util.Scanner;

public class CheckOddEven {
  public static void main(String[] args) {
    
    System.out.print("Enter a number: ");
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    
    if(input%2 == 0) {
      System.out.println("This is even number.");
    }
    else {
      System.out.println("This is odd number.");
    }
  }
}