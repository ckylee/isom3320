import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.Pane;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DoraemonDemo extends Application {
  public void start(Stage stage) {
    Pane pane;
    Scene scene;
    Canvas canvas;
    
    pane = new Pane();
    canvas = new Canvas(200, 200);
    paint(canvas.getGraphicsContext2D());
    pane.getChildren().add(canvas);
    
    scene = new Scene(pane, 200, 200, Color.GREY);
    stage.setScene(scene);
    stage.setTitle("Doraemon");
    stage.show();
  }
  
  public void paint(GraphicsContext g) {
    g.setStroke(Color.BLUE); 
    g.strokeOval(20,20,160,160); 
    
    g.setStroke(Color.WHITE);
    g.strokeOval(30,60,140,120); 
    
    g.setStroke(Color.SILVER);
    g.strokeOval(60,40,40,60);   
    g.strokeOval(100,40,40,60);  
    
    g.setStroke(Color.TOMATO);
    g.strokeOval(92,85,16,16);   

    g.setFill(Color.BROWN);
    g.fillOval(90,80,5,6);     
    g.fillOval(105,80,5,6);    

    g.setFill(Color.RED);
    g.fillArc(55,85,90,80,0,-180,ArcType.OPEN);
    
    g.setStroke(Color.VIOLET);
    g.strokeLine(100,101,100,125);
    
    g.setStroke(Color.YELLOW);
    g.strokeLine(90,108,35,100);
    g.strokeLine(90,112,35,114);
    g.strokeLine(90,116,35,130); 
    
    g.setStroke(Color.ORANGE);
    g.strokeLine(110,108,165,100);
    g.strokeLine(110,112,165,114);
    g.strokeLine(110,116,165,130);
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
  
}