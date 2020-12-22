package ok.test.facebook;

public class SubArraySum {

  public static void main(String[] args) {
    int[] a = {1,1,1};
    System.out.println(subarraySum(a,2));
  }
  
  public static int subarraySum(int[] nums, int k) {
    int[] numSum = new int[nums.length];
    numSum[0] = nums[0];
   
    int count =0;
    
    if(numSum[0]==k) count++;
    
    for(int i=1;i<nums.length;i++) {
      numSum[i] = numSum[i-1] + nums[i];
      if(numSum[i]==k) count++;
    }
    
    for(int i=nums.length-1;i>=0;i--) {
      for(int j=0;j<i;j++) {
        if(numSum[i]-numSum[j]==k) count++;
      }
    }
    return count;
  }
}
