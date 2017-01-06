import java.util.Scanner;

public class AdditionQuiz {
  public static void main(String[] args) {
    
    //generate two random numbers between 0 and 99
    int a = (int)(Math.random()*100);
    int b = (int)(Math.random()*100);
    
    //answer
    int answer = a + b;
    
    //prompt the user for answer
    System.out.println("What is " + a +  "+ " + b + " ?");
    Scanner scanner = new Scanner(System.in);
    int userAnswer = scanner.nextInt();
    
    if (userAnswer == answer) {
      System.out.println("true");
    }
    
    else {
      System.out.println("false");
    }
    
  }
}