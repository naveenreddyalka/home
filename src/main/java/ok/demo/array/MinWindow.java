package ok.demo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWindow {

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(minWindowDP("ADOBECODEBANC", "ABC"));
  }

  public static String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    char key[] = t.toCharArray();
    String tKey = String.valueOf(key);

    int min = -1;
    int minL = -1, minR = -1;

    int l = 0, r = 0;

    while (r < s.length()) {
      char temp[] = s.substring(l, r).toCharArray();
      Arrays.sort(temp);

      while (l < r && String.valueOf(temp).contains(tKey)) {

        if (min == -1 || min < (r - l)) {
          min = r - l;
          minL = l;
          minR = r;
        }
        l++;
        temp = s.substring(l, r).toCharArray();
        Arrays.sort(temp);
      }

      r++;
    }

    return min == -1 ? "" : s.substring(minL, minR);
  }

  public static String minWindowDP(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    char master[] = s.toCharArray();
    char key[] = t.toCharArray();

    Map<Character, Integer> countM = new HashMap<Character, Integer>();

    for (int i = 0; i < master.length; i++) {
      if (countM.get(master[i]) == null) countM.put(master[i], 0);
      countM.put(master[i], countM.get(master[i]) + 1);
    }

    Map<Character, Integer> countK = new HashMap<Character, Integer>();

    for (int i = 0; i < key.length; i++) {
      if (countK.get(key[i]) == null) countK.put(key[i], 0);
      countK.put(key[i], countK.get(key[i]) + 1);
    }
    int i = 0;
    int j = s.length() - 1;
    int minI = 0;
    int minJ = s.length();
    while (i < j) {
      if (countK.containsKey(master[i]) && (countM.get(master[i]) > countK.get(master[i]))) {
        countM.put(master[i], countM.get(master[i]) - 1);
        i++;
      }else {
          i++;
      }

      if (countK.containsKey(master[j]) &&  (countM.get(master[j]) > countK.get(master[j]))) {
        countM.put(master[j], countM.get(master[j]) - 1);
        j--;
      }else {
          j--;
      }

      if ((j - i) < (minJ - minI)) {
        minJ = j;
        minI = i;
      }
    }

    return s.substring(minI, minJ);
  }
}
