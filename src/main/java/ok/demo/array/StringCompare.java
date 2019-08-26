package ok.demo.array;

public class StringCompare {

  public static void main(String[] args) {
          System.out.println(compare("abae", "abcd"));
  }

  private static Integer compare(String s1, String s2) {
    if (s1 == null) {
      return 1;
    }

    if (s2 == null) {
      return -1;
    }

    int l1 = s1.length();
    int l2 = s2.length();
    int c1 = 0;
    int c2 = 0;

    while (c1 < l1 && c2 < l2) {
      if (s1.charAt(c1) == s2.charAt(c2)) {
        c1++;
        c2++;
      } else {
        return (s1.charAt(c1) - s2.charAt(c2)) > 0 ? 1 : -1;
      }
    }

    if(c1==l1 && c2!=l2) {
      return -1;
    }
    if(c1!=l1 && c2==l2) {
      return 1;
    }
    
    return 0;
  }
}
