public class SumDigits {
  public static void main(String[] args) {
    sumDigits(928);
  }
  
  public static int sumDigits(long n) {
    String stringNum = Long.toString(n);
    int sum = 0;
    for(int i = 0; i < stringNum.length(); i++) {
      char digit = stringNum.charAt(i);
      int digitvalue;
      digitvalue = digit - '0';
      sum += digitvalue;
    }
    System.out.println(sum);
    return sum;
  }
}