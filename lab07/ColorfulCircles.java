import javafx.application.Application;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.animation.*;
import javafx.util.*;
import java.lang.*;

public class ColorfulCircles extends Application {
 
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);
        
      //create circles
        Group circles = new Group(); 
        for (int i = 0; i < 30; i++) {    
          Circle circle = new Circle(150, Color.web("white", 0.05));    
          circle.setStrokeType(StrokeType.OUTSIDE);    
          circle.setStroke(Color.web("white", 0.16));    
          circle.setStrokeWidth(4);    
          circles.getChildren().add(circle); 
        } 
        
             //add background gradient
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(), 
             new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                                  Stop[]{          
          new Stop(0, Color.web("#f8bd55")),          
            new Stop(0.14, Color.web("#c0fe56")),          
            new Stop(0.28, Color.web("#5dfbc1")),          
            new Stop(0.43, Color.web("#64c2f8")),          
            new Stop(0.57, Color.web("#be4af7")),          
            new Stop(0.71, Color.web("#ed5fc2")),          
            new Stop(0.85, Color.web("#ef504c")),          
            new Stop(1, Color.web("#f2660f")),})); 
        colors.widthProperty().bind(scene.widthProperty()); 
        colors.heightProperty().bind(scene.heightProperty());
        
        //root.getChildren().add(colors);
        //root.getChildren().add(circles);
        
        

        //apply another overlay blend group
        Group blendModeGroup =  new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),         
                                                                     Color.BLACK), circles), colors); 
        colors.setBlendMode(BlendMode.OVERLAY); 
        root.getChildren().add(blendModeGroup);
        
                
        //add visual effect
        circles.setEffect(new BoxBlur(10, 10, 3));
        
        //add animation
        Timeline timeline = new Timeline(); 
        for (Node circle: circles.getChildren()) {   
          timeline.getKeyFrames().addAll(     
                                         new KeyFrame(Duration.ZERO,     
                                                      new KeyValue(circle.translateXProperty(), Math.random() * 800),     
                                                      new KeyValue(circle.translateYProperty(), Math.random() * 600)   ),     
                                         new KeyFrame(new Duration(40000),     
                                                      new KeyValue(circle.translateXProperty(), Math.random() * 800),     
                                                      new KeyValue(circle.translateYProperty(), Math.random() * 600)         
                                                     )     
                                        ); 
        } 
        timeline.play();
        
        primaryStage.show();
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}