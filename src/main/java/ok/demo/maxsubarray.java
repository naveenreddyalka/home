package ok.demo;

public class maxsubarray {

  public static void main(String[] args) {
    int[] in = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(in));
  }
  
  private static int maxSubArray(int[] nums) {
    int[] max = new int[nums.length];
    max[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (max[i - 1] + nums[i] > nums[i]) {
        max[i] = max[i - 1] + nums[i];
      } else {
        max[i] = nums[i];
      }
    }
    
    int r = Integer.MIN_VALUE;
    
    for (int i = 0; i < max.length; i++) {
      if(max[i]>r) r = max[i];
    }
    
    return r;
  }
}
