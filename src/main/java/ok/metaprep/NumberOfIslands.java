package ok.metaprep;

public class NumberOfIslands {


  public static void main(String[] args) {
    char[][] input = {{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    System.out.println(numIslands(input));
  }

  public static int numIslands(char[][] grid) {
    if(grid==null || grid.length==0) return 0;
    int num_islands = 0;

    for( int i=0; i<grid.length;i++){
      for( int j=0; j<grid[0].length;j++){
          if(grid[i][j] == '1'){
            num_islands++;
            dfs(grid,grid.length,grid[0].length, i, j);
          }
      }
    }
  return num_islands;
  }

  public static void dfs(char[][] grid, int m, int n, int i, int j){
      grid[i][j] = '0';
      if(i+1<m && grid[i+1][j]=='1'){
        dfs(grid,m,n,i+1,j);
      }

      if(i-1>=0 && grid[i-1][j]=='1'){
        dfs(grid,m,n,i-1,j);
      }

      if(j+1<n && grid[i][j+1]=='1'){
        dfs(grid,m,n,i,j+1);
      }

      if(j-1>=0 && grid[i][j-1]=='1'){
        dfs(grid,m,n,i,j-1);
      }
  }
}
