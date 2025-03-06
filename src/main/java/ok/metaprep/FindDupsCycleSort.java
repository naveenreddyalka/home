package ok.metaprep;

import java.util.ArrayList;
import java.util.List;

public class FindDupsCycleSort {

  public static void main(String[] args) {
    int[] nums = {2,3,1,6,6,5,5};
    findDuplicates(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  public static List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;

    // Use cycle sort to place elements
    // at corresponding index to value
    int i = 0;
    while (i < n) {
      int correctIdx = nums[i] - 1;
      if (nums[i] != nums[correctIdx]) {
        swap(nums, i, correctIdx);
      } else {
        i++;
      }
    }

    // Any elements not at the index that corresponds to their value are duplicates
    List<Integer> duplicates = new ArrayList<>();
    for (i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        duplicates.add(nums[i]);
      }
    }

    return duplicates;
  }

  // Swaps two elements in nums
  private static void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  public List<Integer> findDuplicatesInPlace(int[] nums) {
    List<Integer> ans = new ArrayList<>();

    for (int num : nums) {
      nums[Math.abs(num) - 1] *= -1;
    }

    for (int num : nums) {
      if (nums[Math.abs(num) - 1] > 0) {
        ans.add(Math.abs(num));
        nums[Math.abs(num) - 1] *= -1;
      }
    }

    return ans;
  }

  }
