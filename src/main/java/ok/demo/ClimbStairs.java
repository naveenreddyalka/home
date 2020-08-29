package ok.demo;

public class ClimbStairs {

	public static void main(String[] args) {
		ClimbStairs c = new ClimbStairs();
		
		System.out.println(c.climbStairs(4));
	}
	
	public int climbStairs(int n) {
		int[] map  = new int[n+1];
		if(n==1) return 1;
		if(n==2) return 1;
		
		map[1] = 1;
		map[2] = 2;
		return climbStairs(n,map);
		
    }
	
	public int climbStairs(int n, int[] map) {
		
		if(map[n]!=0) return map[n];
		
		int n1 = climbStairs(n-1);
		map[n-1] = n1;
		
		int n2 = climbStairs(n-2);
		map[n-2] = n2;
		
		return n1 + n2;
		
    }
	
	
	public int climbStairs(int c , int n) {
        
		if(c>=n) return 0;
		
		int n1 =  climbStairs(c+1,n);
		
		 int n2 = climbStairs(c+2,n);
		
		return n1 + n2;
		
    }

}
