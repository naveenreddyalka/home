package ok.demo.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class islands {

  static class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
      super();
      this.i = i;
      this.j = j;
    }
  }
  
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    int[][] mat1 = { 
        { 1,  2,  3,  0 }, 
        { 9,  0,  4,  8 }, 
        { 10, 15, 5,  0 }, 
        { 11, 0,  0,  6 },
        { 12, 13, 14, 7 } };
    
    int[][] mat2 = { 
        { 1,  0,  3,  0 }, 
        { 0,  0,  4,  8 }, 
        { 10, 15, 5,  0 }, 
        { 11, 0,  0,  6 },
        { 12, 13, 14, 7 } };

    System.out.println(countIslandsBFS(mat1, 5, 4));
    System.out.println(countIslandsDFS(mat2, 5, 4));
    int[][] vis = new int[5][4];
    //Arrays.setAll(vis, (i) -> 0);
    findShortestPath(mat1, vis, 5, 4, 0,0,0);
    System.out.println(min);
  }

  private static int countIslandsBFS(int[][] mat, int r, int c) {

    int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int count = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (mat[i][j] != 0) {
          Queue<Pair> queue = new LinkedList<Pair>();
          queue.add(new Pair(i,j));
          while (!queue.isEmpty()) {
            Pair current = queue.poll();
            mat[current.i][current.j]=0;
            for(int l=0;l<8;l++) {
              if(isSafe(mat, r, c, current.i+row[l], current.j+col[l])) {
                queue.add(new Pair(current.i+row[l],current.j+col[l]));
              }
            }
          }
          count++;
        }
      }
    }
    return count;
  }
  
  private static int countIslandsDFS(int[][] mat, int r, int c) {

    int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int count = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (mat[i][j] != 0) {
          Stack<Pair> stack = new Stack<Pair>();
          stack.add(new Pair(i,j));
          while (!stack.isEmpty()) {
            Pair current = stack.pop();
            mat[current.i][current.j]=0;
            for(int l=0;l<8;l++) {
              if(isSafe(mat, r, c, current.i+row[l], current.j+col[l])) {
                stack.add(new Pair(current.i+row[l],current.j+col[l]));
              }
            }
          }
          count++;
        }
      }
    }
    return count;
  }

  private static boolean isSafe(int[][] mat, int r, int c, int i , int j) {
    if(i>=0 && i<r && j>=0 && j<c && mat[i][j]!=0) return true;
    else return false;
  }

  private static void findShortestPath(int[][] mat, int[][] vis, int r, int c, int i, int j,int path) {
    int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    if(i==r && j==c) {
      min = Math.min(path, min);
      return;
    }
    if(!isSafeP(mat, vis, r, c, i, j) || mat[i][j]==0) return;
    
    vis[i][j]=1;
    
    for (int k = 0; k < 8; k++) {
      findShortestPath(mat, vis, r, c, i+row[k], j+col[k], path+1);
    }
    
    vis[i][j]=0;
  }
  
  private static boolean isSafeP(int[][] mat, int[][] vis, int r, int c, int i , int j) {
    if(i>=0 && i<r && j>=0 && j<c && mat[i][j]!=0 && vis[i][j]==0) return true;
    else return false;
  }

  
  private static void allPaths(int[][] mat, int[][] vis, int r, int c, int i, int j,String path) {
    int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    if(i==r && j==c) {
      System.out.println(path);
      return;
    }
    if(!isSafeP(mat, vis, r, c, i, j) || mat[i][j]==0) return;
    
    path = path +"-"+mat[i][j];
    vis[i][j]=1;
    
    for (int k = 0; k < 8; k++) {
      allPaths(mat, vis, r, c, i+row[k], j+col[k], path);
    }
    vis[i][j]=0;
  }
}
