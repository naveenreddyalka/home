package ok.metaprep;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CircularArrayLoop {

  public static void main(String[] args) {
    int[] nums = {1,1,2};
    System.out.println(circularArrayLoop(nums));
  }

  // Method to check if the array contains a cycle that meets certain conditions
  public static  boolean circularArrayLoop(int[] nums) {
    int arrayLength = nums.length; // Initialize the arrayLength with the length of nums
    // Loop through each element in the array
    for (int i = 0; i < arrayLength; ++i) {
      // Skip if the current element is 0 as it's already considered non-cyclic
      if (nums[i] == 0) {
        continue;
      }
      // Use a slow and fast pointers approach to find a cycle
      int slow = i;
      int fast = getNextIndex(i,nums);
      // Continue to advance the pointers until the product of the adjacent elements is positive,
      // which indicates they move in the same direction
      while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[getNextIndex(fast,nums)] > 0) {
        if (slow == fast) {
          // If both pointers meet, check if the cycle length is greater than 1
          if (slow != getNextIndex(slow,nums)) {
            return true; // A cycle that meets the conditions is found
          }
          break; // The cycle length is 1, so break out of the loop
        }
        // Move the slow pointer by one and the fast pointer by two
        slow = getNextIndex(slow,nums);
        fast = getNextIndex(getNextIndex(fast,nums),nums);
      }
      // Reset all elements in the detected cycle to 0 to mark them non-cyclic
      int j = i;
      while (nums[j] * nums[getNextIndex(j,nums)] > 0) {
        nums[j] = 0;
        j = getNextIndex(j,nums);
      }
    }
    // No valid cycle found, return false
    return false;
  }

  // Helper method to get the next array index taking into account wrapping of the array
  // and the current item value (handles negative indices as well)
  private static int getNextIndex(int i,int[] nums ) {
    // Calculate the next index based on the current index and its value in the array.
    // The result is wrapped to stay within array bounds
    return (i + nums[i] % nums.length + nums.length) % nums.length;
  }

}
