import java.util.Scanner;

public class CalculateBMI {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    //user input
    System.out.println("Enter weight in pounds");
    double weightInput = scanner.nextDouble();
    
    System.out.println("Enter height in inches");
    double heightInput = scanner.nextDouble();
    
    //convert pounds to kg, inch to meters
    double weight = weightInput *  0.45359237;
    double height = heightInput *  0.0254;
    
    //calculate and print BMI
    double bmi = weight / (height*height);
    System.out.println("BMI: " + bmi);
  }
}