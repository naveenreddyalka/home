package ok.demo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reverse {

  public static void main(String[] args) {

    int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int n = in.length;
    //System.out.println(n / 2);
    for (int i = 0; i < n / 2; i++) {
      int temp = in[n - 1 - i];
      in[n - 1 - i] = in[i];
      in[i] = temp;
    }
    
    // System.out.println(n);
    String str = "abcd";
    //System.out.println("--->"+angarams(str));
    // System.out.println(rev1(str));
    // System.out.println(rev2(str));
    List<String> r = subs(str);
    angarams(str).forEach(System.out::println);

  }

  private static String rev1(String str) {

    if (str == null)
      return null;

    if (str.length() == 1)
      return str;

    return rev1(str.substring(1)) + str.charAt(0);
  }

  private static String rev2(String str) {
    if (str == null)
      return null;

    if (str.length() == 1)
      return str;

    return rev2(str.substring((str.length() / 2), str.length()))
        + rev2(str.substring(0, str.length() / 2));
  }
  
  private static List<String> subs(String str){
    List<String> r = new ArrayList<String>();
    if(str==null) return null;
    if(str.length()==1) {
      r.add("");
      r.add(str);
      return r;
    }
    List<String> sub = subs(str.substring(1));
    sub.forEach(s-> {
      r.add(s);
      r.add(s+str.charAt(0));
    });
    return r;
  }
  
  private static List<String> angarams(String str){
    List<String> r = new ArrayList<String>();
    if(str==null) return null;
    if(str.length()==1) {
      r.add(str);
      return r;
    }
    List<String> sub = angarams(str.substring(1));
    sub.forEach(s-> {
      for(int i=0;i<s.length();i++) {
        r.add(s.subSequence(0, i) + String.valueOf(str.charAt(0)) + s.subSequence(i, s.length()));
      }
    });
    return r;
  }

}
