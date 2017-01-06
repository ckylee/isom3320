public class SmallestInteger {
  public static void main(String[] args) {
    
    //find smallest integer n whose squared is greater than 12000
    int n = 0;
    
    while (n * n < 12000) {
      n++;
    }
    
    System.out.println(n);
  }
}