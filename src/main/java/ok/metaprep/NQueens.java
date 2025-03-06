package ok.metaprep;

public class NQueens {

  static int count = 0;

  public static int solveNQueens(int n) {
    if(n == 0) return 0;

    boolean[][] board = new boolean[n][n];
    solveNQueens(board,0,n);

    return count;
  }

  public static void solveNQueens(boolean[][] board, int queens, int n) {
    if(queens==n) {
      count++;
      return;
    }

    for(int i=0; i<n; i++ ){
      if(isValid(board,queens,i,n)){
        board[queens][i] = true;
        solveNQueens(board,queens+1,n);
      }
      board[queens][i] = false;
    }
  }

  public static boolean isValid(boolean[][] board, int i , int j, int n){
    for(int k=0;k<n;k++){
     if(board[i][k] || board[k][j]) return false;

     if(i-k >=0 && j-k >=0 && board[i-k][j-k] ) return false;
     if(i+k<n && j+k<n && board[i+k][j+k]) return false;
     if(i-k>=0 && j+k<n && board[i-k][j+k]) return false;
     if(i+k<n && j-k>=0 && board[i+k][j-k]) return false;

    }

  return true;
  }

  public static void main(String[] args) {

    System.out.println( solveNQueens(5));
  }
}
