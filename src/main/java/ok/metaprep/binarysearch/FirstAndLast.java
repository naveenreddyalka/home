package ok.metaprep.binarysearch;

import java.util.Arrays;

public class FirstAndLast {

  public static void main(String[] args) {
      int[] nums = {5,7,7,8,8,8,10};
    System.out.println(Arrays.toString(findRange(nums,8)));
  }

  public static int[] findRange(int[] nums, int target){
    if(nums==null || nums.length==0) return new int[]{-1,-1};
    int first = bsFindFirst(nums, target);
    int last = (first==-1)?-1:bsFindLast(nums, target);
    return new int[]{first,last};
  }

  public static int bsFindFirst(int[] nums, int target){
    int i= 0, j = nums.length-1;
    int f = -1;
    while(i<=j){
      int m = i + (j-i)/2;
      if(nums[m]==target){
        f = m;
        j = m-1;
      } else if(nums[m]<target){
        i = m+1;
      } else {
        j = m-1;
      }
    }
    return f;
  }

  public static int bsFindLast(int[] nums, int target){
    int i= 0, j = nums.length-1;
    int l = -1;
    while(i<=j){
      int m = i + (j-i)/2;
      if(nums[m]==target){
        l = m;
        i = m+1;
      } else if(nums[m]<target){
        i = m+1;
      } else {
        j = m-1;
      }
    }
    return l;
  }

}
