public class Account {
  private int id = 0;
  private double balance = 0;
  private static double annualInterestRate = 0;
  private java.util.Date dateCreated;
  
  //no-arg constructor default account
  Account() {
  }
  
  //create account with id and balance
  Account (int accountID, double accountBalance) {
    id = accountID;
    balance = accountBalance;
  }
  
  int getID() {
    return this.id;
  }
  
  double getBalance() {
    return this.balance;
  }
  
  double getAnnualInterestRate() {
    
  }
  
  public static void main(String[] args) {
  }
  
}