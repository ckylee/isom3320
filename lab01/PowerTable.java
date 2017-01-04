public class PowerTable {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {2, 3, 4, 5, 6};
    
    //print "a    b   pow(a,b)"
    System.out.println("a\tb\tpow(a, b)");
    
    
    //loops through a, b array calculating power and printing them out
    for(int i = 0; i < a.length; i++) {
      
      int pow = (int) Math.pow(a[i], b[i]);
      
      System.out.print(a[i]);
      System.out.print("\t");
      System.out.print(b[i]);
      System.out.print("\t");
      System.out.println(pow);
    }
    
  }
}