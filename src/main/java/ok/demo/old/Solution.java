package ok.demo.old;

public class Solution {
    
    public static void main(String[] args) {
	System.out.println((new Solution()).solution(561892) ); 
    }
    public int solution(int N) {
        boolean start =false;
	int max = 0;
	int l_max=0;
	while(N > 0)
        {
            int a = N % 2;
            if(a==1) {
		if (start) {
		    if (l_max > max) {
			max = l_max;
		    }
		    l_max = 0;
		}else {
        	    start=true;
        	}
            }
            if(start && a==0) l_max++;
            
            N = N / 2;
        }
	return max;
    }
    
    
}
