import javax.swing.*;

public class AssignGrade {
    
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        String inputStr;
        int numberOfStudents;
        int[] scores;  // array scores
        int best;      // the best score
        char grade;    // the grade
        String output; // output string
        
        // Get number of students
        inputStr = JOptionPane.showInputDialog("Please enter number of students: ");
        numberOfStudents = Integer.parseInt(inputStr);
        
        scores = new int[numberOfStudents];
        best = 0;
        output = "";
        
        // Read scores and find the best score
        for (int i = 0; i < scores.length; i++) {
            inputStr = JOptionPane.showInputDialog("Please enter a score for student " + (i+1) + " : ");
            scores[i] = Integer.parseInt(inputStr);
            
            if (scores[i] > best)
                best = scores[i];
        }
        
        // Assign and display grades
        /*** write your code here ***/
        for (int i = 0; i < scores.length; i++) {
          if (scores[i] >= best - 10)
            grade = 'A';
          else if (scores[i] >= best - 20)
            grade = 'B';
          else if (scores[i] >= best - 30)
            grade = 'C';
          else if (scores[i] >= best - 40)
            grade = 'D';
          else
            grade = 'F';
          
          output += "Student " + (i+1) + " grade is " + grade + "\n";
          
        }
        
        
        // Display the result
  /*** write your code here ***/
        System.out.println(output);
    }
}