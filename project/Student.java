
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;

public class Student {
  private static int windowWidth = Canvas.getWindowWidth(), windowHeight = Canvas.getWindowHeight();
  private static double speed = 3;
  private static ImageView studentImage;
  private static Image studentImage_raw;
  private static Node studentNode; 
  private static boolean moveUp, moveDown, moveLeft, moveRight, speedUp; 
  private static int xcoord, ycoord;
  private static int xinput = 535, yinput = 250;
  
  
  public static Node setStudent(Scene scene) throws Exception {
    studentImage_raw = new Image("images/Student.png");
    studentImage = new ImageView(studentImage_raw);
    studentNode = studentImage;
    
    //MOVE the student according to the arrow keys pressed, by changing boolean values used in moveStudent()
    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent e) {
        switch (e.getCode()) {
          case UP: moveUp = true; break;
          case DOWN: moveDown = true; break;
          case LEFT: moveLeft = true; break;
          case RIGHT: moveRight = true; break;
          case SPACE: speedUp = true; break;
        }}});
    
    //STOP the movement when the keys are released, by changing boolean values used in moveStudent()
    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent e) {
        switch (e.getCode()) {
          case UP: moveUp = false; break;
          case DOWN: moveDown = false; break;
          case LEFT: moveLeft = false; break;
          case RIGHT: moveRight = false; break;
          case SPACE: speedUp = false; break;
        }}});
    
    Timer.animate(); 
    return studentNode; 
  }
  
  //to animate the student, called from Timer.animate
  public static void moveStudent(){
    double xmove = 0, ymove = 0;
    if(moveUp) 
      ymove = -speed;
    if (moveDown)
      ymove = +speed;
    if (moveLeft)
      xmove = -speed;
    if (moveRight)
      xmove = +speed; 
    if (speedUp) {
      xmove *= 2.5; 
      ymove *= 2.5; 
    }
    
    //student hitting the edge will come back in from the other side 
    xinput += xmove; 
    yinput += ymove;
    
    if (xinput >= 0)
      xcoord = xinput % windowWidth -35;  
    else 
      xcoord = windowWidth + xinput % windowWidth -35; 
    
    if (yinput >= 0)
      ycoord = yinput % windowHeight -20;
    else 
      ycoord = windowHeight + yinput % windowHeight -20; 
    
    studentNode.relocate(xcoord, ycoord);   //relocating the student 
  }
  
  
  //==OTHERS===================================================================
  //get methods to let other classes access the student's coordinates 
  public static int getXcoord() {
    return xcoord;
  }
  public static int getYcoord() {
    return ycoord; 
  }
  
  //resetting student related elements for new game 
  public static void resetElements() {
    xinput = 535;
    yinput = 250; 
    moveUp = moveDown = moveLeft = moveRight = speedUp = false; 
  }
}
