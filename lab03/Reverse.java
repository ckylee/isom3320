public class Reverse {
  public static void main(String[] args){
    reverse(12345);
  }
  
  public static void reverse(int number) {
    String reversed = "";
    String num = Integer.toString(number);
    for(int i = 0; i < num.length(); i++){
      char character = num.charAt(i);
      reversed = character + reversed ;
    }
    System.out.println(reversed);
  }

}