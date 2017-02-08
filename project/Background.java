import javafx.scene.*;
import javafx.scene.image.*;


public class Background {  
  private static Image studentImage;
  private static Node studentNode; 
  
  
  //background image
  public static Node setBackground() throws Exception {
    studentImage = new Image("images/background.jpg", 1000, 600, false, false);
    studentNode = new ImageView(studentImage);
    
    return studentNode; 
  }
  
  
  //instructions 
  public static Node setInstructionsImage() throws Exception {
    Image instructionsBackground = new Image("images/StartBackground.png", 1000, 600, false, false);
    Node instructionsNode = new ImageView(instructionsBackground);
    
    return instructionsNode; 
  }
}