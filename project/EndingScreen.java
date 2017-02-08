public class EndingScreen {
  public static void setEndPane() throws Exception {
    Canvas.endPane.getChildren().addAll(Background.setBackground()); 
    Canvas.endPane.getChildren().addAll(Scores.getTopPlayers());
  }
}
