package ok.toptal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Toptal2 {

  public static void main(String[] args) {
    int[] res = {7, 3, 7, 3, 1, 3, 4, 1};
    System.out.println(solution3(11));
  }

  public int solution(int[] A) {
    int min = 100000000;
    boolean found = false;
    Map<Integer, Integer> maps = new HashMap<Integer, Integer>();

    for (int i = 0; i < A.length; i++) {
      maps.put(i, A[i]);
    }

    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        boolean isAdj = true;
        for (Integer key : maps.keySet()) {
          if (key != i
              && key != j
              && ((A[i] > maps.get(key) && maps.get(key) > A[j])
                  || (A[i] < maps.get(key) && maps.get(key) < A[j]))) {
            isAdj = false;
          }
        }
        if (isAdj) {
          found = true;
          if (Math.abs(A[i] - A[j]) < min) {
            min = Math.abs(A[i] - A[j]);
          }
        }
      }
    }

    if (found) {
      return min == 100000000 ? -1 : min;
    }
    return -2;
  }

  public static int solution2(int[] A) {
    Map<Integer, Integer> maps = new HashMap<Integer, Integer>();

    for (int i = 0; i < A.length; i++) {
      if (maps.get(A[i]) != null) {
        maps.put(A[i], maps.get(A[i]) + 1);
      } else {
        maps.put(A[i], 1);
      }
    }

    int i = 0;
    int j = A.length - 1;
    int min = A.length - 1;

    while (j - i > (maps.size())) {
      if (maps.get(A[j]) > 1) {
        j--;
        maps.put(A[j], maps.get(A[j]) - 1);
      }
      if (maps.get(A[i]) > 1) {
        i++;
        maps.put(A[i], maps.get(A[i]) - 1);
      }
      if (j - i < min) {
        min = j - i;
      }
    }

    return min + 1;
  }

  private static boolean findAll(Map<Integer, Integer> maps, int[] A, int i, int j) {
    boolean missed = false;
    for (; i <= j; i++) {
      maps.put(A[i], 1);
    }
    for (Integer key : maps.keySet()) {
      if (maps.get(key) == 0) {
        missed = true;
      }
    }

    for (Integer key : maps.keySet()) {
      maps.put(key, 0);
    }
    return missed ? false : true;
  }

  private static String solution3(int N) {

    List<String> res1 = new ArrayList<String>();
  
    Boolean r1 = value("", 0, 1, N, res1);
  
    String out = "";
    if (r1 == false) {
      return "impossible";
    }

    if (r1) {
      for (String a : res1) {
        out = out + a;
      }
    }
    return out;
  }

  private static boolean value(String dir, int L, int R, int N, List<String> path) {

    if (R == N || L == N) {
      return true;
    }
    if (Math.abs(R) > Math.abs(N) || Math.abs(L) > Math.abs(N)) {
      return false;
    }

    if (dir.equals("L")) {
      L = 2 * L - R;
      path.add(dir);
    }

    if (dir.equals("R")) {
      R = 2 * R - L;
      path.add(dir);
    }

    if (value("L", L, R, N, path)) {
      return true;
    }

    if (value("R", L, R, N, path)) {
      return true;
    }

    path.remove(path.size() - 1);

    return false;
  }
}
