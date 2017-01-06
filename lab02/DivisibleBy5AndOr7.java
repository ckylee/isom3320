import java.util.Scanner;

public class DivisibleBy5AndOr7 {
  public static void main(String[] args) {
    
    //get integer from user
    System.out.print("Enter an integer: ");
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    
    //is it divisible by 5 AND 7?
    System.out.print("Is it divisible by 5 and 7? ");
      
    if(input % 5 == 0 && input % 7 == 0) {
      System.out.println("true");
    }
    else {
      System.out.println("false");
    }

  //is it divisible by 5 OR 7?
    System.out.print("Is it divisible by 5 or 7? ");
    if(input % 5 == 0 || input % 7 == 0) {
      System.out.println("true");
    }
    else {
      System.out.println("false");
    }

   //is it divisible by 5 OR 7, but not BOTH?
    System.out.print("Is it divisible by 5 or 7, but not both? ");
    if((input % 5 == 0 || input % 7 == 0) && (!(input % 5 == 0 && input % 7 == 0))) {
      System.out.println("true");
    }
    else {
      System.out.println("false");
    }

  }
}