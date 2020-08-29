package ok.demo.array;

public class MinSubArray {

	public static void main(String[] args) {
		int[] s = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, s));
	}
	
	
	public static int minSubArrayLen(int s, int[] nums) {
	      
        int t = nums.length;
       
        if(t==0) return 0;
       
        int l=0;
        int r = 0; 
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while(l<t && r<t && r>=l){
        	if(s<=sum){
               min = Math.min(min,r-l+1); 
               sum=sum-nums[l];
               l++;
            }else{
            	r++;
	            if(r<t-1) {
	            	sum=sum+nums[r];
            	}
            }
           
        }
        return min;
    }
}
