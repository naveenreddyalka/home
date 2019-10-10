package ok.toptal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class countPaliondrom {

    public static Comparator<Integer> AgeComparator = new Comparator<Integer>() {

        @Override
        public int compare(Integer e1, Integer e2) {
            return 0;
        }
    };
    
  public static void main(String[] args) {

    
      List<Integer> nums = new ArrayList<Integer>();
      //5, 7, 9, 13, 11, 6, 6, 3, 3
      nums.add(5);
      nums.add(7);
      nums.add(9);
      nums.add(13);
      nums.add(11);
      nums.add(6);
      nums.add(6);
      nums.add(3);
      nums.add(3);
      
      Collections.sort(nums, (a,b)->{
          return a-b;
      });
      
    System.out.println(countPairs(nums,12));
    //  System.out.println(getCount("abcb"));

  }
  
 

  public static int getCount(String a) {
    if (a == null || a.length() == 0) {
      return 0;
    } else if (a.length() == 1) {
      return 1;

    } else {

      int count = 0;
      Set<String> dups = new HashSet<String>();

      for (int i = 0; i < a.length(); i++) {
        int l = i;
        int m = i;

        while (l >= 0 && m < a.length()) {

          if (a.charAt(l) == a.charAt(m)) {
            count++;
            dups.add(a.substring(l, m + 1));
            l--;
            m++;

          } else {
            break;
          }
        }

        l = i;
        m = i + 1;
        while (l >= 0 && m < a.length()) {

          if (a.charAt(l) == a.charAt(m)) {
            dups.add(a.substring(l, m + 1));
            count++;
            l--;
            m++;

          } else {
            break;
          }
        }
      }

      return dups.size();
    }
  }

  public static int getOddPrime(int a, int b, int c) {
    int count = 0;

    for (int i = a; i < b; i++) {
      if (checkprime(i) && checkCat(i, c)) {
        count++;
      }
    }
    if (a < 2) {
      count = count - 1;
    } else if (a == 2) {
      count = count - 2;
    }
    return count;
  }

  public static boolean checkprime(int n) {
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) return false;
    }

    return true;
  }

  public static boolean checkCat(int n, int c) {
    if (c == 1) {
      while (c > 0) {
        if (c % 10 > 5) {
          return false;
        }
        c = c / 10;
      }
      return true;
    }

    if (c == 2) {
      while (c > 0) {
        if (c % 10 < 5) {
          return false;
        }
        c = c / 10;
      }

      return true;
    }

    return false;
  }

  public static int getMaxCount(List<Integer> nums) {

    int max = 0;
    for (int i = 0; i < nums.size(); i++) {
      for (int j = i + 1; i < nums.size(); i++) {
        int l = i;
        int m = j;
        int count = 0;
        int n = j + 1;
        while (n < nums.size() - 2) {
          if (nums.get(n) == (nums.get(l) + nums.get(m))) {
            count++;
            l = m;
            m = n;
          } else {
            n++;
          }
        }
        if (max < count) max = count;
      }
    }

    return max;
  }
  
  public static int countPairs(List<Integer> nums, int k) {
      Collections.sort(nums);
      int i=0 ; int j=nums.size()-1;
      Set<String> counts = new HashSet<String>();
      
      while(j>i) {
          if(nums.get(i)+nums.get(j) > k) {
              j--;
          }else if (nums.get(i)+nums.get(j) > k) {
              i++;
          }else {
              counts.add(""+nums.get(i)+""+nums.get(j));
              i++;j--;
          }
      }
      return counts.size();
  }
}
