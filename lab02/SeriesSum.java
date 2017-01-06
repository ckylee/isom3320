public class SeriesSum {
  public static void main(String[] args) {
    
    double sum = 0;
    int a = 1;
    
     //48 odd numbers 1..97
    for(int i = 0; i < 97; i++) {
      int b = a + 2;
      sum = (double) a / b;
      a = b;
    }
    
    System.out.println("Sum is " + sum);
      
  }
}