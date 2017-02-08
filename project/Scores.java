import java.text.DecimalFormat;
import javafx.scene.control.Label;
import java.util.Arrays; 
import javafx.scene.control.TextInputDialog; 
import java.util.Optional; 
import javafx.event.EventHandler;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javafx.scene.text.Font;


public class Scores { 
  //for calculating scores
  private static int gradesEaten;  //5 gradesEaten --> +1 semester 
  private static int semester = 1;
  private static double totalPoints = 0.00;  //total points from grades eaten, A=4, B=3, C=2, D=1
  private static double gpa;  //gpa = totalPoints/gradesEaten
  private static double gameScore;  //gameScore = gpa*semester
  
  //for ranking top 3 scores
  private static int rankOfPlayer; 
  private static double[] topScoresComparison = new double[3];  //double for comparison
  
  //for formatting and displaying scores on game pane, and highscores in ending screen
  private static DecimalFormat myFormatter = new DecimalFormat("0.00");
  private static String scoreString;
  private static Label scoreLabel = new Label("Semester: 1   GPA: -.--   Game Score: -.--"); //in top left corner of game pane 
  private static String nameInput, topPlayers; 
  private static Label topScoresLabel = new Label("high scores");  //for displaying highscore in ending screen
  private static JFrame dummyFrame; 
  private static String[][] topScoresString = new String[3][3];  //3*[rank][Name][Score] in String
  
  
  //==DURING THE GAME===================================================================
  //update scores for after each grade is eaten, called from Grades.isHit method
  public static void updateScores(int intGrades) {
    int newPoint = (int)'E' - intGrades;  //calculate the score input from each grade eaten
    totalPoints += newPoint;
    
    gradesEaten++;
    if (gradesEaten % 5 == 0) //5 grades eaten --> +1 semester 
      semester++; 
    
    gpa = totalPoints / gradesEaten; 
    gameScore = gpa * semester; 
    
    scoreString = "Semester: " + semester + "   GPA: " + myFormatter.format(gpa) + "   Game Score: " + myFormatter.format(gameScore); 
    scoreLabel.setText(scoreString);  //update scores on the game pane 
  }
  
  //==FOR TOP SCORES===================================================================
  //activate sudden death of users (hitting F Grade) starting from the 2nd semester, update scores 
  public static void suddenDeath() {
    if (semester > 1){
      Timer.timer.stop();
      endGame(); 
    }
  }
  
  
  //update top scores and player name if new top score is created, otherwise go to ending screen directly 
  public static void endGame() {
    if (isTopScore()) {  //scores will only be updated if a new score is created, otherwise the users will be brought to the end screen directly 
      dummyFrame = new JFrame(); 
      dummyFrame.setAlwaysOnTop(true); 
      nameInput = JOptionPane.showInputDialog(dummyFrame, "Congratulations! You have created a new highscore!", "name");
      
      //Exceptions handling to accept all sorts of inputs for name, "anonymous" will be shown if player press cancel or leave field blank 
      if(nameInput == null || nameInput.trim().length() == 0)
        nameInput = "Anonymous";
      nameInput = nameInput.replace("null", "nu##n--replace--ment##ll").replace(",","##comma--replace--ment##").replace("[","##openBracket--replace--ment##").replace("]","##closeBracket--replace--ment##");
      
      topScores(); 
      setName(); 
      topScoresLabel.setFont(new Font("Courier New", 20));
      topScoresLabel.setText(topPlayers); 
    }
    Canvas.stage.setScene(Canvas.endScene);
    GameElements.resetAllElements();  //reset all elements except highscores for a new game 
  }
  
  
  //ask for the players' name if a new top 3 score is created, otherwise lead to ending screen directly 
  public static boolean isTopScore() {
    if (gameScore > topScoresComparison[2])
      return true;
    else 
      return false;
  }
  
  
  //update the information of the top 3 scores 
  public static String[][] topScores() {
    if (gameScore > topScoresComparison[0]) {
      rankOfPlayer = 1; 
      shiftPositions(rankOfPlayer);      
    } else if (gameScore > topScoresComparison[1]) {
      rankOfPlayer = 2; 
      shiftPositions(rankOfPlayer);
    } else if (gameScore > topScoresComparison[2]) {
      rankOfPlayer = 3; 
      shiftPositions(rankOfPlayer);    
    } 
    topScoresString[0][0] = "1st   ";
    if (topScoresString[1][2] != null) topScoresString[1][0] = "\n2nd   ";
    if (topScoresString[2][2] != null) topScoresString[2][0] = "\n3rd   ";
    
    return topScoresString; 
  }
  
  
  //rearrange the positions of the top players, add information of new top scorer 
  public static void shiftPositions(int rank) { 
    for(int j = topScoresComparison.length; j > 1; j--) {
      topScoresComparison[j-1] = topScoresComparison[j-2];
      System.arraycopy(topScoresString[j-2], 1, topScoresString[j-1], 1, 2); 
    } 
    topScoresComparison[rank-1] = gameScore; 
    topScoresString[rank-1][2] = scoreString + "\n\n";
  }
  
  
  //set the player name into the top score panel 
  public static void setName() {
    nameInput += "\n      "; 
    topScoresString[rankOfPlayer -1][1] = nameInput;
    
    topPlayers = Arrays.deepToString(topScoresString); 
    topPlayers = topPlayers.replace("null", "").replace(",", "").replace("[", "").replace("]", "").replace("##comma--replace--ment##", ",").replace("##openBracket--replace--ment##", "[").replace("##closeBracket--replace--ment##", "]").replace("##n--replace--ment##", "");
  }
  
  
  //==OTHERS===================================================================
  //get methods to let other classes access the variables
  public static int getSemester() {
    return semester;
  }
  public static Label updateLabel() {
    return scoreLabel;
  }
  public static Label getTopPlayers() {
    topScoresLabel.setTranslateX(200);
    topScoresLabel.setTranslateY(225);
    return topScoresLabel;
  }
  
  
  //resetting scores for new game 
  public static void resetElements() {
    gradesEaten = 0;
    semester = 1;
    gpa = 0;
    totalPoints = 0; 
    scoreLabel.setText("Semester: 1   GPA: --   Game Score: --");
  }
  
}
