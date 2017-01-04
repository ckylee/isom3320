import java.util.Scanner;

public class CalculateFutureInvestmentValue {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    //get input
    System.out.println("Enter investment amount: ");
    double investmentAmount = scanner.nextDouble();
    System.out.println("Enter annual interest rate (nominal %): ");
    double annualInterestRate = scanner.nextDouble();
    System.out.println("Enter number of years: ");
    double numberOfYears = scanner.nextDouble();
    
    //convert annual interest rate to monthly interest rate (effective interest rate when compounded)
    annualInterestRate = 0.01 * annualInterestRate;
    double monthlyInterestRate = annualInterestRate / 12;
    
    //calculate and print
    double futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate), (numberOfYears*12));
    System.out.println("Future Investment Value: " + futureInvestmentValue);
    
  }
}