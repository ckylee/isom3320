public class TicTacToeRandom {
  public static void main(String[] args) {
    
    //generate random tictactoe
    int[][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
    
    for(int i =0; i < board.length; i++) {
      for(int j =0; j < 3; j++) {
        board[i][j] = (int) Math.floor(Math.random() * 9) % 2;
        System.out.print(board[i][j]);
      }
      System.out.println("");
    }
    
    //columns
    for(int i=0; i < board.length; i++) {
      if((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))
        System.out.println("All " + board[0][i] + "s on column " + i);
    }
    
    //rows
    for(int i=0; i < board.length; i++) {
      if((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]))
        System.out.println("All " + board[i][0] + "s on row " + i);
    }
    
    //diagonals
    if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) || (board[2][2] == board[1][1]) && (board[1][1] == board[2][0]))
      System.out.println("All " + board[1][1] + " on subdiagonal");


    
  }
  
}