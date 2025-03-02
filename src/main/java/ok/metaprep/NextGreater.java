package ok.metaprep;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import ok.demo.tree.result;

public class NextGreater {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nextGreaterElements2(new int[]{1,2,1})));
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0)
      return new int[]{};

    // value to index of next greater element
    Map<Integer, Integer> nextG = new HashMap<Integer, Integer>();

    //Integer[] res = new Integer[nums1.length];
    //Arrays.fill(res, -1); 1,2,3

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        nextG.put(stack.pop(), nums2[i]);
      }
      stack.push(nums2[i]);
    }
    while (!stack.isEmpty())
      nextG.put(stack.pop(), -1);

    int[] res = new int[nums1.length];

    for (int i = 0; i < nums2.length; i++) {
      res[i] = nextG.get(nums1[i]);
    }

    return res;
  }

  // in a circular array
  public static int[] nextGreaterElements2(int[] nums) {

    int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();
    int max = (nums.length*2)-1;

    for(int i=0; i<= max; i++){
        while(!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]){
          result[stack.pop()] = nums[i%nums.length];
        }
        if(result[i%nums.length]==-1)
          stack.push(i%nums.length);
      }

    return result;
    }

  public static int[] nextGreaterElements3(int[] nums) {

    int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();
    int max = (nums.length*2)-1;

    for(int i=0; i<= max; i++){
      while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%nums.length]){
        stack.pop();
      }

      result[stack.pop()] = nums[i%nums.length];
      if(result[i%nums.length]==-1)
        stack.push(i%nums.length);
    }

    return result;
  }


}



