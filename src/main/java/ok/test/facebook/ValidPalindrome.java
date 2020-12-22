package ok.test.facebook;

public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(validPalindrome(
        "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
  }

  public static boolean validPalindromeOld(String s) {
    int l = s.length() - 1;
    int i = 0;
    Boolean over = false;
    while (i < l) {
      if (s.charAt(i) != s.charAt(l)) {
        if (!over) {
          over = true;
          if (s.charAt(i + 1) == s.charAt(l)) {
            i++;
          } else {
            l--;
          }
          continue;
        }
        return false;
      }
      i++;
      l--;
    }

    return true;
  }

  static Boolean over = false;

  public static boolean validPalindrome(String s) {
    int l = s.length() - 1;
    int i = 0;
    while (i < l) {
      if (s.charAt(i) != s.charAt(l)) {
        if (!over) {
          over = true;
          if (validPalindrome(s.substring(i + 1, l+1))
              || validPalindrome(s.substring(i, l))) {
              return true;
          }
        }
        return false;
      }
      i++;
      l--;
    }

    return true;
  }

}
