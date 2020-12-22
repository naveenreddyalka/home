package ok.test.leetcode;

public class MaxWidthRamp {

	public static void main(String[] args) {
		//int[] A = {6,0,8,2,1,5};
		int[] A = {8,5,6,4,10,3,1};
		
		System.out.println(maxWidthRamp(A));
	}
	
	public static int maxWidthRamp(int[] A) {
	       
        int max = A.length-1;
        int now = 0;

        int l = A.length-1;
       
        while(now!=max){
            int i=l-max;
            int j=A.length-1;
            boolean broke = false;
            while(i<j){
                if(A[i] <= A[j]){
                    if(max == (j-i)) {
                        return j-i;
                    }
                    now = Math.max(now, j-i); 
                    max--;
                    broke = true;
                    break;
                }else{
                    j--;
                }
            }
            
            if(!broke) max--;
            
        }
        
        return now;
    }
	
}
