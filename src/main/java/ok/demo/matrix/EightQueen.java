package ok.demo.matrix;

import java.util.ArrayList;
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

}
