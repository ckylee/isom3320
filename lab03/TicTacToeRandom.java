public class TicTacToeRandom {
  public static void main(String[] args) {
    
    //generate random tictactoe
    int[][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
    
    for(int i =0; i < board.length; i++) {
      for(int j =0; j < 3; j++) {
        board[i][j] = (int) Math.floor(Math.random() * 9) % 2;
      }
    }
    
    System.out.print(board);
    
    
  }
  
}