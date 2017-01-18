import javafx.application.Application;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;

public class LoginForm extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX Welcome");
    
    //create gridpane layout
    GridPane grid = new GridPane(); 
    grid.setAlignment(Pos.CENTER); 
    grid.setHgap(10); 
    grid.setVgap(10); 
    grid.setPadding(new Insets(25, 25, 25, 25));
    Scene scene = new Scene(grid, 320, 240); 
    primaryStage.setScene(scene);
    
    //create components for the form
    Text scenetitle = new Text("Welcome"); 
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); 
    grid.add(scenetitle, 0, 0, 2, 1);
    Label userName = new Label("User Name:"); 
    grid.add(userName, 0, 1);
    TextField userTextField = new TextField(); grid.add(userTextField, 1, 1);
    Label pw = new Label("Password:"); grid.add(pw, 0, 2);
    PasswordField pwBox = new PasswordField(); grid.add(pwBox, 1, 2);
    
    //add button and text
    Button btn = new Button("Sign in"); 
    HBox hbBtn = new HBox(10); 
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT); 
    hbBtn.getChildren().add(btn);
    grid.add(hbBtn, 1, 4);
    
    //add text control
    final Text actiontarget = new Text(); 
    grid.add(actiontarget, 1, 6);
    
    //event handler for button
    btn.setOnAction(new EventHandler<ActionEvent>() {    
      @Override    
      public void handle(ActionEvent e) {       
        actiontarget.setFill(Color.FIREBRICK);       
        actiontarget.setText("Sign in button pressed");     
      } 
    });

    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}