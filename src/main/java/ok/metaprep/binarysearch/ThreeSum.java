package ok.metaprep.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-3,-2,-1,0,1,2,3};
    threeSum(nums);
  }

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
   Arrays.sort(nums);

    for(int k=0; k<nums.length;k++){

      int i = k+1, j = nums.length-1;
      if(nums[k]>0) break;
      if(k>0 && nums[k-1]==nums[k]) break;

        while(i<j){
          if(nums[i] + nums[j] + nums[k] == 0){
            result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j],nums[k])));
            i++;
            j--;
          }else if(nums[i] + nums[j] + nums[k] < 0){
            i++;
          }else{
            j--;
          }
        }
    }
    return result;
  }
}
