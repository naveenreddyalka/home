package ok.metaprep.print;

public class FirstMissingPositive {

  // use cycle sort to sort in place and find the first missing positive integer
  public static int firstMissingPositiveInteger(int[] nums) {
    int len = nums.length;
    int curr = 0;

    while(curr<len){
      int val = nums[curr];
      if(val>0 && val<len && val!=nums[val-1]){
        int temp = nums[curr];
        nums[curr] =  nums[val-1];
        nums[val-1] = temp;
      }else{
        curr++;
      }
    }

    for(int i=0; i< len;i++){
      if(nums[i]!=i+1){
        return i+1;
      }
    }

    return len+1;
  }

}
