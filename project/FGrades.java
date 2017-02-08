import javafx.scene.control.Label;
import java.util.Random; 
import javafx.scene.*;
import javafx.scene.image.*;

public class FGrades {
  private static int numberOfF = 5;
  private static Label[] grades = new Label[numberOfF];
  private static int[] intGrades = new int[numberOfF];
  private static double[] gradesSpeedX = new double[numberOfF];
  private static double[] gradesSpeedY = new double[numberOfF];
  private static int windowWidth = Canvas.getWindowWidth(), windowHeight = Canvas.getWindowHeight();
  private static Image gradeImage;
  private static Node[] gradeImageNode = new Node[numberOfF]; 
  
  
  //setting the GradeF mushrooms and adding to the game pane 
  public static Node[] setFGradeImage() throws Exception {
    gradeImage = new Image("images/GradeF.png", 35, 35, false, false);
    for (int i = 0; i < gradeImageNode.length; i++) {
      gradeImageNode[i] = new ImageView(gradeImage); 
    }
    return gradeImageNode; 
  }
  
  
  //Initiate the positions and moving speed of the F Grades  
  public static Label[] setFGrades() {
    for(int i =0; i < grades.length; i++) {
      intGrades[i] = 'F';
      grades[i] = new Label(Character.toString((char)intGrades[i]));
      grades[i].setTranslateX(getRandomInteger(50, windowWidth - 50));  //position
      grades[i].setTranslateY(getRandomInteger(50, windowHeight - 50));  //position
      gradesSpeedX[i] = Math.random()*4 - 2;  //speed
      gradesSpeedY[i] = Math.random()*4 - 2;  //speed
      grades[i].setVisible(false);
    }
    return grades;
  }
  
  
  //make the grades move in random directions at random speeds 
  public static void moveFGrades() {
    for (int i = 0; i < grades.length; i++){
      double gradeX = grades[i].getTranslateX();
      double gradeY = grades[i].getTranslateY();
      double yinput = 0, xinput = 0, xcoord = 0, ycoord = 0;
      
      //move the grades 
      gradeX += gradesSpeedX[i]*(1 + Scores.getSemester()/4);
      gradeY += gradesSpeedY[i]*(1 + Scores.getSemester()/4);
      
      //grades hitting the edge will come back in from the other side 
      xinput += gradeX; 
      if (xinput >= 0)
        xcoord = xinput % windowWidth;  
      else 
        xcoord = windowWidth + xinput % windowWidth; 
      
      yinput += gradeY;
      if (yinput >= 0)
        ycoord = yinput % windowHeight;
      else 
        ycoord = windowHeight + yinput % windowHeight; 
      
      //relocating the grades 
      grades[i].setTranslateX(xcoord);
      grades[i].setTranslateY(ycoord);
      gradeImageNode[i].setTranslateX(xcoord); 
      gradeImageNode[i].setTranslateY(ycoord);
    }
  }
  
  
  
  //When the F grades are hit by the student, semester 1: no effect, starting from semester 2: end game 
  public static void isHit(int xcoord, int ycoord) {
    for(int j=0; j < grades.length; j++) {
      double gradeX = grades[j].getTranslateX();
      double gradeY = grades[j].getTranslateY(); 
      
      if (xcoord +25 > gradeX && gradeX > xcoord -25
            && ycoord +38 > gradeY && gradeY > ycoord -25){
        Scores.suddenDeath();
      }
    }
  }
  
  
  //for generating a random integer between 2 integers
  public static int getRandomInteger(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }
}