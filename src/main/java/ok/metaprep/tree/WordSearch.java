package ok.metaprep.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {

  public static void main(String[] args) {

    // push and pop
    Deque<TreeNode> stack = new LinkedList<>();
    // offer and poll
    Queue<TreeNode> queue = new LinkedList<>();

    char[][] board = {{'A','B','C','E'},
                      {'S','F','E','S'},
                      {'A','D','E','E'}};
    System.out.println(exist(board,"ABCESEEEFS"));


    System.out.println(wordSearch(board,"ABCESEEEFS"));
  }


  public static boolean wordSearch(char[][] grid, String word) {
    if(grid==null || word==null) return false;

    int m = grid.length;
    int n = grid[0].length;

    boolean[][] vistied = new boolean[m][n];


    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        vistied[i][j] = true;
        if(dfs(grid,word,0,i,j,m,n,vistied) ) return true;
      }
    }

    return  false;
  }
  public static boolean dfs(char[][] grid,String word,int idx, int i, int j, int m, int n,boolean[][] vistied){
    if(idx>=word.length() || grid[i][j]!=word.charAt(idx)) return false;

    if(idx==word.length()-1) return true;

    vistied[i][j] = true;

    if(i-1>=0 && !vistied[i-1][j] && dfs(grid,word,idx+1,i-1,j, m,n,vistied)){
      return true;
    }

    if(i+1<m && !vistied[i+1][j] && dfs(grid,word,idx+1,i+1,j,m,n,vistied)){
      return true;
    }

    if(j-1>=0 && !vistied[i][j-1] && dfs(grid,word,idx+1,i,j-1,m,n,vistied)){
      return true;
    }

    if(j+1<n && !vistied[i][j+1] && dfs(grid,word,idx+1,i,j+1,m,n,vistied)){
      return true;
    }

    vistied[i][j] = false;

    return false;
  }


  public static boolean exist(char[][] board, String word) {
    if(board==null || board.length==0) return false;
    int m = board.length;
    int n = board[0].length;
    boolean[][] boardBool = new boolean[m][n];
    for(int i=0; i <m;i++ ){
      for(int j=0; j<n; j++){
        if(!boardBool[i][j]){
          boardBool[i][j] = true;
          if(board[i][j]==word.charAt(0)){
          boolean found = dfs(board,i,j,m,n,0,word,"",new boolean[m][n]);
            if(found) return true;
          }
        }
        }
      }

    return false;
  }

  public static boolean dfs(char[][] board,int i, int j, int m , int n, int curr,String word,String soFar,boolean[][] boardBool){
    soFar = soFar + board[i][j];
    boardBool[i][j] = true;
    if(word.equals(soFar)) return true;


    if(j>0 && !boardBool[i][j-1] && board[i][j-1]==word.charAt(curr+1)){
      boolean found = dfs(board,i,j-1,m,n,curr+1,word,soFar,boardBool);
      if(found) return true;
    }

    if(i>0 && !boardBool[i-1][j] && board[i-1][j]==word.charAt(curr+1)){
      boolean found = dfs(board,i-1,j,m,n,curr+1,word,soFar,boardBool);
      if(found) return true;
    }

    if(i<m-1 && !boardBool[i+1][j] && board[i+1][j]==word.charAt(curr+1)){
      boolean found = dfs(board,i+1,j,m,n,curr+1,word,soFar,boardBool);
      if(found) return true;
    }

    if(j<n-1 && !boardBool[i][j+1] && board[i][j+1]==word.charAt(curr+1) ){
      boolean found = dfs(board,i,j+1,m,n,curr+1,word,soFar,boardBool);
      if(found) return true;
    }
    boardBool[i][j] = false;
    return false;

  }
}
