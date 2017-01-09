import javax.swing.*;

public class TestArray {
    
    /** Main method */
    public static void main(String[] args) {       
        final int TOTAL_NUMBERS = 6;
        int[] numbers = new int[TOTAL_NUMBERS];
        String inputStr;
        int max;
        int count = 0;
        String output;
        
        // Read all numbers
        for (int i = 0; i < numbers.length; i++) {
            inputStr = JOptionPane.showInputDialog("Enter a number: ");
            
            // Convert string into integer
            numbers[i] = Integer.parseInt(inputStr);
        }
        
        // Find the largest
  /*** write your code here ***/
        max = numbers[0];
        for (int j = 1; j < numbers.length; j++) {
          if(numbers[j] > max) {
            max = numbers[j];
          }
        }
        // Find the occurrence of the largest number
        /*** write your code here ***/
        count = 0;
        for (int i =0; i < numbers.length; i++) {
          if (numbers[i] == max)
          {
            count++;
          }
        }
        // Prepare the result
        output = "The array is ";
  /*** write your code here ***/
        for (int i = 0; i < numbers.length; i++) {
          output += numbers[i] + " ";
        }
  
  
        output += "\nThe largest number is " + max;
        output += "\nThe occurrence count of the largest number "
                  + "is " + count;
        
        // Display the result
        System.out.println(output);
    }
}