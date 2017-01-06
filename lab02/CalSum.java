import java.util.Scanner;

public class CalSum {
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int sum = 0;
    
    int input = scanner.nextInt();
    
    while(input > 0)
    {
      sum = sum + input;
      input = scanner.nextInt();
    }
    
      System.out.println("Sum is: " + sum);
  }
  
}