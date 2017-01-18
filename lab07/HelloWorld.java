import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
  
  @Override
  public void start(Stage primaryStage) {   // main entry point for all JavaFX applications
    
    // create a Button object (btn), and define the event handler for the button
     Button btn = new Button();     
     btn.setText("Say 'Hello World'");
     
     btn.setOnAction(new EventHandler<ActionEvent>() {
       @Override       
       public void handle(ActionEvent event) {         
         System.out.println("Hello World!");       
       }     
     });
    
    // create a StackPane object (root), add the Button object to it
    StackPane root = new StackPane();
     root.getChildren().add(btn);
    
    // create a Scene, and add the StackPane object to it
    Scene scene = new Scene(root, 300, 250); 
     
    // setup the Stage and show to the screen
     primaryStage.setTitle("Hello World!");     
     primaryStage.setScene(scene);     
     primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}