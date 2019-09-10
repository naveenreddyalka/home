package ok.demo.array;

import java.util.ArrayList;
import java.util.List;

public class stringsubstrings {

  public static void main(String[] args) {
    //List<List<String>> x = getAllSubStrings("abcd");
    System.out.println(getAll("abcd"));
  }

  private static List<List<String>> getAllSubStrings(String a) {
    if (a.length() == 1) {
      List<List<String>> out = new ArrayList<List<String>>();
      List<String> in = new ArrayList<String>();
      in.add(a);
      out.add(in);
      return out;
    } else {
      List<List<String>> rest = getAllSubStrings(a.substring(1, a.length()));
      List<String> last = rest.get(rest.size() - 1);
      List<String> current = new ArrayList<String>();
      for (String s : last) {
        current.add(a.charAt(0) + s);
      }
      current.add(a.charAt(0) + "");
      rest.add(current);
      return rest;
    }
  }

  private static List<String> getAll(String a) {

    List<String> res = new ArrayList<String>();
    if (a == null) return null;
           
        for(int i=0;i<a.length();i++) {
            //res.add(String.valueOf(a.charAt(i)));
            for(int j=i+1;j<=a.length();j++) {
                res.add(a.substring(i,j));
            }
        }
  

    return res;
  }
}
