package ok.test;

public class test {

  public static void main(String[] args) {
    test t = new test();
    int[] s = {4, 5, 6};
    t.shortestSubarray(s, 3);
  }

  public int shortestSubarray(int[] A, int K) {

    int min = -1;

    int[] S = new int[A.length];
    S[0] = A[0];

    for (int i = 0; i < A.length - 1; i++) {
      S[i + 1] = S[i] + A[i + 1];
    }
    
    return min;
  }
}
