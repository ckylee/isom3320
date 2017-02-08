import javafx.animation.AnimationTimer;

public class Timer{
  public static AnimationTimer timer;
  
  //animation timer to move all the objects smoothly  
  public static void animate() {
    timer = new AnimationTimer() {
      @Override 
      public void handle(long i) {
        Student.moveStudent(); 
        Grades.isHit(Student.getXcoord(), Student.getYcoord());  //checking if the grades are hit 
        Grades.moveGrades();
        FGrades.moveFGrades();
        FGrades.isHit(Student.getXcoord(), Student.getYcoord());     
      }
    }; 
  }
  
  
  
  
}