public class SplitStringBySeparator {
  
  public static void main(String[] args) throws Exception {
    String string1 = "element0, element1, element2, element3, element4";
    System.out.println("This is my string  >>>" + string1 + "<<<");
    
    int countComma = 0;
    for (int i=0; i<string1.length(); i++) {
      if (string1.substring(i, i+1).equals(",")) {   // substring(from position, to position)
        countComma++;
      }
    }
    System.out.println("Your string is " + string1.length() + "-character long.");
    System.out.println("There are totally " + (countComma + 1) + " elements in your string.");
    
    // declare a String Array, with array size = 5
    String[] stringArray1 = new String[5];
    
    // split the string by comma ","
    stringArray1 = string1.split(",");
    
    for (int i=0; i<5; i++) {
      System.out.println(i + " :  " + ">>>"+ stringArray1[i] + "<<<");
    }
    
    for (int i=0; i<5; i++) {
      // remove unwanted leading and trailing space
      System.out.println(i + " :  " + ">>>"+ stringArray1[i].trim() + "<<<");
    }
  }
  
  // Think point: how to make the size dynamic?
}