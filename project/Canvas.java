import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.scene.control.Label; 
import javafx.event.*;
import javafx.scene.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Canvas extends Application {
  private static final int windowWidth = 1000, windowHeight = 600;
  public static Stage stage;
  public static Scene startScene, gameScene, endScene;
  public static Pane startPane, gamePane, endPane;
  public static Button startButton, playAgain;
  public static AudioClip audio;
  public static MediaPlayer bgm;
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;  //use stage outside start() method
    
    //background music and audio effects 
    audio = new AudioClip(getClass().getResource("mp3/Mario-coin-sound.mp3").toString());
    Media pick = new Media(getClass().getResource("mp3/bgm.mp3").toExternalForm());
    bgm = new MediaPlayer(pick);
    bgm.setCycleCount(MediaPlayer.INDEFINITE);
    bgm.play();
    
    //start screen
    startPane = new Pane();
    startPane.getChildren().addAll(Background.setInstructionsImage()); 
    startScene = new Scene(startPane, windowWidth, windowHeight);
    startButton = new Button(" ", new ImageView(new Image("images/here.png", 67, 35, false, false)));
    startButton.relocate(645, 500);
    startButton.setStyle("-fx-background-color: transparent;"); 
    startButton.setOnAction(e-> ButtonClicked(e));
    startPane.getChildren().addAll(startButton);
    primaryStage.setScene(startScene);
    
    
    //game play
    gamePane = new Pane();
    gameScene = new Scene(gamePane, windowWidth, windowHeight); 
    GameElements.refreshGamePane();
    
    
    //end screen
    endPane = new Pane();
    endScene = new Scene(endPane, windowWidth, windowHeight);
    EndingScreen.setEndPane(); 
    playAgain = new Button(" ", new ImageView(new Image("images/playAgain.png", 153, 36, false, false)));
    playAgain.setStyle("-fx-background-color: transparent;"); 
    playAgain.relocate(427, 160);
    playAgain.setOnAction(e-> ButtonClicked(e));
    endPane.getChildren().addAll(playAgain);
    
    
    //Exceptions handing: pause game and music when the window is not focused (e.g. clicks outside of the game window accidentally) 
    primaryStage.focusedProperty().addListener(new ChangeListener<Boolean>(){
      @Override
      public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1){
        if(stage.isFocused() == false){
          Timer.timer.stop();
          bgm.pause();
        }
        else {
          if(stage.getScene() == gameScene)
            Timer.timer.start();
          bgm.play();
        }
      }
    });
    //players are not allowed to change the window size, screen size >1000*600 is required for this game 
    primaryStage.setResizable(false);  
    primaryStage.show();
  }
  
  
  //switch scenes when the buttons are pressed 
  public void ButtonClicked(ActionEvent e) {
    if (e.getSource()== startButton){
      Timer.timer.start();
      stage.setScene(gameScene);
    }
    if (e.getSource()== playAgain){
      stage.setScene(startScene);
    }
  }
  
  
  //for other classes to access these variables 
  public static int getWindowWidth() {
    return windowWidth;  
  }
  public static int getWindowHeight() {
    return windowHeight; 
  }
  public static void main(String[] args) {
    launch(args);
  }
}