package ok.metaprep.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class FindKClosestElements {



  public static String removeDuplicates(String s) {
    Stack<Character> stac = new Stack();
    for (int i = 0; i < s.length(); i++) {
      if (stac.peek() == s.charAt(i)) {
        stac.pop();
        continue;
      }
      stac.push(s.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    while (!stac.isEmpty()) {
      sb.append(stac.pop());
    }
    return sb.reverse().toString();
  }


  public static void main(String[] args) {
    int[] test = {1, 2, 3, 4, 5};
    List<Integer> r = findClosestElements(test, 4, 3);
    System.out.println(r.toArray());
  }

  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    // Initialize binary search bounds
    int left = 0;
    int right = arr.length - k;

    // Binary search against the criteria described
    while (left < right) {
      int mid = (left + right) / 2;
      if (Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    // Create output in correct format
    List<Integer> result = new ArrayList<Integer>();
    for (int i = left; i < left + k; i++) {
      result.add(arr[i]);
    }

    return result;
  }

  public static List<Integer> findClosestElementsSlow(int[] arr, int k, int x) {
    if (arr == null || arr.length == 0) {
      return null;
    }

    int closest = -1;
    int l = 0, r = arr.length - 1;
    while (r - l > 1) {
      int mid = l + (r - l) / 2;
      if (arr[mid] > x) {
        r = mid;
      } else if (arr[mid] < x) {
        l = mid;
      } else {
        closest = mid;
        break;
      }
    }

    List<Integer> result = new ArrayList<>();

    int ll, rr;
    if (closest != -1) {
      ll = closest;
      rr = closest + 1;
    } else {
      ll = l;
      rr = r;
    }

    while (result.size() < k && (ll >= 0 && rr < arr.length)) {
      if (Math.abs(arr[ll] - x) <= Math.abs(arr[rr] - x)) {
        result.add(arr[ll]);
        ll--;
      } else {
        result.add(arr[rr]);
        rr++;
      }
    }
    if (result.size() < k) {
      if (ll < 0) {
        while (result.size() < k) {
          result.add(arr[rr]);
          rr++;
        }
      } else {
        while (result.size() < k) {
          result.add(arr[ll]);
          ll--;
        }
      }
    }
    Collections.sort(result);
    return result;
  }

  public static List<Integer> findClosestElementsExcludeX(int[] arr, int k, int x) {
    if (arr == null || arr.length == 0) {
      return null;
    }

    int closest = -1;
    int l = 0, r = arr.length - 1;
    while (r - l > 1) {
      int mid = l + (r - l) / 2;
      if (arr[mid] > x) {
        r = mid;
      } else if (arr[mid] < x) {
        l = mid;
      } else {
        closest = mid;
        break;
      }
    }

    List<Integer> result = new ArrayList<>();

    int ll, rr;
    if (closest != -1) {
      ll = closest - 1;
      rr = closest + 1;
    } else {
      ll = l;
      rr = r;
    }

    while (result.size() < k && (ll >= 0 && rr < arr.length)) {
      if (Math.abs(arr[ll] - x) <= Math.abs(arr[rr] - x)) {
        result.add(arr[ll]);
        ll--;
      } else {
        result.add(arr[rr]);
        rr++;
      }
    }
    if (result.size() < k) {
      if (ll < 0) {
        while (result.size() < k) {
          result.add(arr[rr]);
          rr++;
        }
      } else {
        while (result.size() < k) {
          result.add(arr[ll]);
          ll--;
        }
      }
    }
    return result;
  }


}
