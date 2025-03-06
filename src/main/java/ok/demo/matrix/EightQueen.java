package ok.demo.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EightQueen {
  public static void main(String[] args) {

    int[][] chess = new int[8][8];
    List<Integer> rows = new ArrayList<Integer>();
    rows.add(0);rows.add(1);rows.add(2);rows.add(3);rows.add(4);rows.add(5);rows.add(6);rows.add(7);
    boolean test = put(chess, rows);
    System.out.println(chess);
  }

  private static boolean put(int[][] chess, List<Integer> rows) {
    if(rows.size()==0) return true;

    int putr =  rows.remove(0);

    for(int i=0;i<chess.length;i++) {
      int[][] temp = chess;
      if(temp[putr][i]==0) {
        temp[putr][i]=8;
        mark(temp, putr, i);
        if (put(temp, rows)) {
          chess = temp;
          return true;
        } else
          rows.add(0,putr);
      }
    }

    return false;
  }

  private static void mark(int[][] chess, int x, int y) {
    for(int i=0;i<chess[0].length;i++) {
      if(chess[x][i]==0)chess[x][i]=1;
    }

    for(int i=0;i<chess.length;i++) {
      if(chess[i][y]==0)chess[i][y]=1;
    }

    for(int i=0;i<chess.length;i++) {
      if(x+i<chess.length && y+i<chess[0].length) {
        if(chess[x+i][y+i]==0)chess[x+i][y+i]=1;
      }
      if(x-i>=0 && y-i>=0) {
        if(chess[x-i][y-i]==0)chess[x-i][y-i]=1;
      }
    }

    for(int i=0;i<chess.length;i++) {
      if(x+i<chess.length && y-i>=0) {
        if(chess[x+i][y-i]==0)chess[x+i][y-i]=1;
      }
      if(x-i>=0 && y+i<chess[0].length) {
        if(chess[x-i][y+i]==0)chess[x-i][y+i]=1;
      }
    }

  }



 /* public static String repeat(String str, int count) {
    String result = "";
    for (int i = 0; i<count; i++) {
      result += str;
    }
    return result;
  }

  public static void solveNQueensRec(int n, List<Integer> solution, int row, List<List<Integer>> results) {
    if (row == n) {
      results.add(solution);
      return;
    }

    for (int i = 0; i<n; i++) {
      boolean valid = isValidMove(row, i, solution);
      if (valid) {
        solution.set(row, i);
        solveNQueensRec(n, solution, row + 1, results);
      }
    }
  }

  // Function to solve N-Queens problem
  public static int solveNQueens(int n) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> solution = new ArrayList<Integer> (Collections.nCopies(n, -1));
    solveNQueensRec(n, solution, 0, results);
    return results.size();
  }

  // this method determines if a queen can be placed at proposed_row, proposed_col
  // with current solution i.e. this move is valid only if no queen in current
  // solution may attack the square at proposed_row and proposed_col
  public static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
    int oldRow =0, oldCol = 0, diagonalOffset = 0;
    for (int i = 0; i<proposedRow; i++) {
      oldRow = i;
      oldCol = solution.get(i);
      diagonalOffset = proposedRow - oldRow;

      if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol + diagonalOffset) {
        return false;
      }
    }

    return true;
  }

  public static void main(String args[]) {
    List<Integer> n = Arrays.asList(4, 5, 6, 7, 8);
    for (int i = 0; i<n.size(); i++) {
      System.out.println(i + 1 + ".\tQueens: " + n.get(i) + ", Chessboard: (" + n.get(i) + "x" + n.get(i) + ")");
      int res = solveNQueens(n.get(i));
      System.out.println("\n\tTotal solutions count for " + n.get(i) + " queens on a (" + n.get(i) + "x" + n.get(i) + ") chessboard: " + res);
      System.out.println(repeat("-", 100));
    }
  }*/

}
