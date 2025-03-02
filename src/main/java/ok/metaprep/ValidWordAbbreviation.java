package ok.metaprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidWordAbbreviation {

  public static void main(String[] args) {
    System.out.println( validWordAbbreviation("internationalization","i12iz4n"));
    List<Node> p_p = new ArrayList<>();
    Collections.reverse(p_p);
  }
  public static boolean validWordAbbreviation(String word, String abbr) {
    if(word==null || abbr==null) return false;

    int wl = word.length();
    int al  = abbr.length();

    if(wl==0 || al ==0 || wl<al) return false;
    int i=0,j=0;
    while(i<wl && j<al) {
      if(word.charAt(i)==abbr.charAt(j)) {
        i++; j++;
        continue;
      }

      if(abbr.charAt(j)=='0' || !Character.isDigit(abbr.charAt(j))){
        return false;
      }
      int t = 0;
      while(j<al && Character.isDigit(abbr.charAt(j))){
        t = t*10 + abbr.charAt(j)-'0';
        j++;
        //t = t*10 + Character.getNumericValue(abbr.charAt(j));
      }
      i = i+t;
    }

    return i==wl && j==al;
  }

}
