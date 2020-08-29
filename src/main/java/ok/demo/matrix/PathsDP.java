package ok.demo.matrix;

public class PathsDP {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 2));
	}
	
	public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                
                if(j+1 <= n-1)
                    dp[i][j] = dp[i][j] + dp[i][j+1];
                
                if(i+1 <= m-1)
                    dp[i][j] = dp[i+1][j] + dp[i][j];
            }
            
        }
        
        return dp[0][0];
    }
}
