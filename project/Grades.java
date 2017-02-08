import javafx.scene.control.Label;
import javafx.application.Platform;
import java.util.Random; 
import javafx.scene.*;
import javafx.scene.image.*;


public class Grades {
  private static int numberOfGrades = 20;
  private static Label[] grades = new Label[numberOfGrades];
  private static int[] intGrades = new int[numberOfGrades]; 
  private static boolean[] hit = new boolean[numberOfGrades];
  private static double[] gradesSpeedX = new double[numberOfGrades];
  private static double[] gradesSpeedY = new double[numberOfGrades];
  private static int windowWidth = Canvas.getWindowWidth(), windowHeight = Canvas.getWindowHeight();
  private static Image gradeA, gradeB, gradeC, gradeD;
  private static Node[] gradeImageNode = new Node[numberOfGrades]; 
  
  
  //place the grades on the game pane 
  public static Node[] setGradeImage() throws Exception {
    gradeA = new Image("images/GradeA.png", 35, 35, false, false);
    gradeB = new Image("images/GradeB.png", 35, 35, false, false);
    gradeC = new Image("images/GradeC.png", 35, 35, false, false);
    gradeD = new Image("images/GradeD.png", 35, 35, false, false);
    
    for (int i = 0; i < gradeImageNode.length; i++) {
      switch (intGrades[i]) {
        case (int)'A':  gradeImageNode[i] = new ImageView(gradeA); break;
        case (int)'B':  gradeImageNode[i] = new ImageView(gradeB); break;
        case (int)'C':  gradeImageNode[i] = new ImageView(gradeC); break;
        case (int)'D':  gradeImageNode[i] = new ImageView(gradeD); break;
        default: gradeImageNode[i] = new ImageView(gradeA); break; 
      } 
    }
    return gradeImageNode; 
  }
  
  
  //Initiate the positions and moving speed of the Grades 
  public static Label[] setGrades() {
    Random r = new Random();
    for(int i =0; i < grades.length; i++) {
      intGrades[i] = (r.nextInt(4) + 'A'); 
      grades[i] = new Label(Character.toString((char)intGrades[i])); 
      grades[i].setTranslateX(getRandomInteger(50, windowWidth - 50));
      grades[i].setTranslateY(getRandomInteger(50, windowHeight - 50));
      gradesSpeedX[i] = Math.random()*4 - 2; //getRandomInteger(-2, 2);//Initialize X coord speed
      gradesSpeedY[i] = Math.random()*4 - 2; //getRandomInteger(-2, 2);//Initialize Y coord speed
      grades[i].setVisible(false);
    }
    return grades;
  }
  
  
  //set the grades to move in random directions at random speeds 
  public static void moveGrades(){
    for (int i = 0; i < grades.length; i++){
      double gradeX = grades[i].getTranslateX();
      double gradeY = grades[i].getTranslateY();
      
      //move the grades 
      gradeX += gradesSpeedX[i]*(1 + Scores.getSemester()/4);
      gradeY += gradesSpeedY[i]*(1 + Scores.getSemester()/4);
      
      //grades hitting the edge will come back in from the other side (including those eaten)
      double yinput = 0, xinput = 0, xcoord = 0, ycoord = 0;
      xinput += gradeX; 
      if (xinput >= 0)
        xcoord = xinput % windowWidth;  
      else {
        xcoord = windowWidth + xinput % windowWidth; 
        addEatenGrades(i); 
      }
      
      yinput += gradeY;
      if (yinput >= 0)
        ycoord = yinput % windowHeight;
      else {
        ycoord = windowHeight + yinput % windowHeight;    
        addEatenGrades(i);
      }
      
      //relocating the grades 
      grades[i].setTranslateX(xcoord);
      grades[i].setTranslateY(ycoord);
      gradeImageNode[i].setTranslateX(xcoord); 
      gradeImageNode[i].setTranslateY(ycoord);
    }
  }
  
  //refill the grades eaten by the player 
  public static void addEatenGrades(int i) {
    hit[i] = false; 
    gradeImageNode[i].setVisible(!hit[i]); 
  }
  
  
  //When the grades are hit by the student 
  public static void isHit(int xcoord, int ycoord) {
    for(int j=0; j < grades.length; j++) {
      double gradeX = grades[j].getTranslateX();
      double gradeY = grades[j].getTranslateY(); 
      
      if (hit[j] == false 
            && xcoord +25 > gradeX && gradeX > xcoord -25
            && ycoord +38 > gradeY && gradeY > ycoord -25){
        
        backgroundMusic(); 
        Scores.updateScores(intGrades[j]);
        hit[j] = true; 
        gradeImageNode[j].setVisible(!hit[j]);
      }
    }
  }
  
  
  //lower bgm volume when user hits grades
  public static void backgroundMusic(){
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Platform.runLater(new Runnable() {
            @Override 
            public void run() {
              Canvas.audio.play();
              Canvas.bgm.setVolume(0.3);
            }
          });
          Thread.sleep(400);
          Canvas.bgm.setVolume(1);
        }
        catch (InterruptedException ex) {
        }
      }
    }).start();
  }
  
  
  //generate random integer between 2 integers 
  public static int getRandomInteger(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }
  
  
}