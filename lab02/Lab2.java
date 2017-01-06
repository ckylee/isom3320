import javax.swing.*;

public class Lab2 {
    public static void main(String[] args) {
        String inputStr = JOptionPane.showInputDialog(null, "Input a number", "Input", JOptionPane.QUESTION_MESSAGE);
        int inputValue = Integer.parseInt(inputStr);

        if(inputValue > 1 && inputValue < 20) {
                  System.out.println(inputValue);
        }
        
        else {
          System.out.println("Your input value is not between 1 and 20.");
        }
    }
}