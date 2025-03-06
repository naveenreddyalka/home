package ok.metaprep;

import java.util.Arrays;

public class FloodFill {
  public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {

    if(grid[sr][sc]==target) return grid;
    fill(grid,sr,sc,grid[sr][sc],target,grid.length-1,grid[0].length-1);
    return grid;
  }

  public static void fill(int[][] grid,int sr, int sc,int original, int target, int m , int n){
    grid[sr][sc] = target;

    if(sr-1>=0 && grid[sr-1][sc]==original){
      fill(grid,sr-1,sc,original,target,m,n);
    }

    if(sr+1<m && grid[sr+1][sc]==original){
      fill(grid,sr+1,sc,original,target,m,n);
    }

    if(sc-1>=0 && grid[sr][sc-1]==original){
      fill(grid,sr,sc-1,original,target,m,n);
    }

    if(sc+1<n && grid[sr][sc+1]==original){
      fill(grid,sr,sc+1,original,target,m,n);
    }

  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,0,1,0},{0,0,0,0,1},{0,0,0,1,1},{1,1,1,1,0},{1,0,0,0,0}};
    floodFill(grid,4,3,3);
    System.out.println(grid);
  }
}
