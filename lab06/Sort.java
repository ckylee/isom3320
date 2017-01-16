import javax.swing.*;
import java.awt.*;

class Student{
    /*student_ID contains the student ID number*/
    public String studentID = "";
    
    /*student_Name contains the student name*/
    public String studentName = "";
    
    /*letter_Grade contains the grade of corresponding student*/
    public char letterGrade = '\0';

}

public class Sort{
    private static int size = 50;
    
    public static void main (String[] args){
        int counter = 0;
        Student[] arrayList = new Student[size];
        String string = "";
        
        do {
            string = JOptionPane.showInputDialog(null, "Please enter a student ID to sort: (-1 to end)", "You can input "+(size-counter)+" more!", JOptionPane.QUESTION_MESSAGE);
            // Continue receiving user inputs
            if(!string.equals("-1")) {
              arrayList[counter] = new Student();
              arrayList[counter].studentID = string;
              string = JOptionPane.showInputDialog(null, "Please enter student name", "Student name please", JOptionPane.QUESTION_MESSAGE);
              arrayList[counter].studentName = string;
              string = JOptionPane.showInputDialog(null, "Please enter student grade", "Letter grade please", JOptionPane.QUESTION_MESSAGE);
              arrayList[counter++].letterGrade = string.toCharArray()[0];
            }
        } while (counter < size && string.compareTo("-1") != 0);
        
        string = JOptionPane.showInputDialog(null, "Sort by : name, ID or grade otherwise ", "Student name please", JOptionPane.QUESTION_MESSAGE);
        
        //Bubble Sort
        //Invoke the static method bubblesort here
        Alg.bubblesort(arrayList, counter, string);
        
        String result = "";
        for (int k = 0; k < counter; k++)
            result += arrayList[k].studentID+"  "+arrayList[k].studentName+"  "+arrayList[k].letterGrade+"\n";
        JOptionPane.showMessageDialog(null, "The sorted result is:\n"+result,"Sorting finished", JOptionPane.INFORMATION_MESSAGE);
    }
}