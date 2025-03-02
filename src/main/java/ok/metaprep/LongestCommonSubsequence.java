package ok.metaprep;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

  public static void main(String[] args) {
    longestCommonSubsequence("hofubmnylkra","pqhgxgdofcvmr");
  }

  static Map<String,Integer> store = new HashMap<>();

  public static int longestCommonSubsequence(String text1, String text2) {
    if(text1==null || text2==null || text1.length()==0 || text2.length()==0)
      return 0;

    String texts = text1+"-"+text2;
    if(store.get(texts)!=null){
      return store.get(texts);
    }

      int r;
      if(text1.charAt(0)==text2.charAt(0)){
        r =  1+ longestCommonSubsequence(text1.substring(1),text2.substring(1));
      }else{
        r= Math.max(longestCommonSubsequence(text1.substring(1),text2),   longestCommonSubsequence(text1,text2.substring(1)));
      }
    store.put(texts,r);

    return r;
  }

}
