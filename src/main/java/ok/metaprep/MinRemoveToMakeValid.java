package ok.metaprep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValid {

  public static void main(String[] args) {
      String test = "lee(t(c)o)de)";
    System.out.println(minRemoveToMakeValid(test));
  }
  public static String minRemoveToMakeValid(String s) {
      Stack<Integer> store = new Stack();
      Set<Integer> toBeRemoved = new HashSet();
    List<Integer> soFar = new ArrayList<>();
    soFar.remove(soFar.size()-1);
    new ArrayList<>(soFar);

      for(int i =0; i< s.length();i++){
        Character c = s.charAt(i);
        if(c.equals('(')){
          store.push(i);
        } else if(c.equals(')')){
          if(store.isEmpty() || !(s.charAt(store.peek()) ==('('))){
            toBeRemoved.add(i);
          }else{
            store.pop();
          }
        }else{
          continue;
        }
      }

      while(!store.isEmpty()) toBeRemoved.add(store.pop());
      StringBuilder sb = new StringBuilder();

    for(int i =0; i< s.length();i++){
        if(!toBeRemoved.contains(i))
             sb.append(s.charAt(i));
    }
    return sb.toString();
  }

}
