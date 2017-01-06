public class LargestInteger {
  public static void main(String[] args) {
    
    //find largest integer n whose squared is less than 30000
    int n = 0;
    
    while (n * n < 30000) {
      n++;
    }
    
    System.out.println(n);
  }
}