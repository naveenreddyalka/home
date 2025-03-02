package ok.metaprep.subsets;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutation {

  public static ArrayList<String> permuteWord(String word){
    ArrayList<String> result = new ArrayList<>();
    Set<Character> curr = new LinkedHashSet<>();
    fill(curr, word,result);
    return result;
  }

  public static void fill(Set<Character> curr,String word,ArrayList<String> result){
    if(curr.size()==word.length()){
      result.add(new String(toString(curr)));
      return;
    }

    for(int i=0; i< word.length();i++){
      if(!curr.contains(word.charAt(i))){
        curr.add(word.charAt(i));
        fill(curr,word,result);
        curr.remove(word.charAt(i));
      }
    }

  }

  public static String toString(Set<Character> curr){
    StringBuilder sb = new StringBuilder();
    for(Character c : curr){
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    permuteWord("xyz");
  }

}
