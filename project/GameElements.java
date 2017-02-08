public class GameElements {
  public static void refreshGamePane() throws Exception {
    //background
    Canvas.gamePane.getChildren().addAll(Background.setBackground());
    
    //grade objects
    Canvas.gamePane.getChildren().addAll(Grades.setGrades()); 
    Canvas.gamePane.getChildren().addAll(Grades.setGradeImage());  
    
    //F grade objects
    Canvas.gamePane.getChildren().addAll(FGrades.setFGradeImage());
    Canvas.gamePane.getChildren().addAll(FGrades.setFGrades());  
    
    //the player 
    Canvas.gamePane.getChildren().addAll(Student.setStudent(Canvas.gameScene));
    Canvas.gamePane.getChildren().addAll(Scores.updateLabel()); 
  }
  
  //to reset elements for new game 
  public static void resetAllElements() {
    Scores.resetElements();
    Student.resetElements();  
  }
}