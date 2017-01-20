import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;


public class ImagePanel extends Application implements EventHandler<ActionEvent> { 
  private ImageView bg; 
  private ImageView plane; 
  private AudioClip audio;
  
  //handle() is from the interface class EventHandler
  public void handle(ActionEvent event) {
    if(plane.getX() > 250)
      plane.setX(0);
    else
      plane.setX(plane.getX() + 10);
    
    if(plane.getX() == 0)
      audio.play();
  }
  public void start(Stage stage) {
    Pane pane = new Pane(); 
    plane = new ImageView(new Image("bomb01.gif")); 
    bg = new ImageView(new Image("land.jpg"));
    audio = new AudioClip(getClass().getResource("/fly.wav").toString());
    pane.getChildren().addAll(bg, plane); 
    stage.setScene(new Scene(pane, 300, 300)); 
    stage.setTitle("Game Demo");
    
    //animate
    Timeline timeline = new Timeline(); 
    timeline.getKeyFrames().add(new KeyFrame(new Duration(100), this));
    timeline.setCycleCount(Timeline.INDEFINITE); timeline.play();
    stage.show(); 
  } 
  
  public static void main(String[] args) {
    launch(args);
  }
}