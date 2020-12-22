package ok.demo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

  public static void main(String[] args) {
    System.out.println(findAnagrams("abab", "ab"));
  }
  
  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<Integer>();
   
    if(s==null || p==null || p.isEmpty() || s.isEmpty()){
        return result;
    }
    
    Map<Character,Integer> pCount = new HashMap<Character,Integer>();
    int w = p.length();
    int i=0;
    int n = s.length();
    
    for(int pl=0; pl<w; pl++){
        Character a = p.charAt(pl);
        if(pCount.containsKey(a)){
            pCount.put(a,pCount.get(a)+1);
        }else{
            pCount.put(a,1);
        }
    }
    
    while(i<(n-w+1)){
        Map<Character,Integer> pTemp = new HashMap<Character,Integer>(pCount);
        
        for(int j=0; j<w; j++){
            Character c = s.charAt(j+i);
            if(pTemp.get(c)!=null){
                if(pTemp.get(c)==1){
                    pTemp.remove(c);
                }else{
                    pTemp.put(c,pTemp.get(c)-1);
                }
            }
        }
        
        if(pTemp.size()==0){
          result.add(i);  
        }
        
        i++;
    }
    
    while(i<(n)){
      Map<Character,Integer> pTemp = new HashMap<Character,Integer>(pCount);
      
      for(int j=0; j<w; j++){
          Character c = s.charAt(j+i);
          if(pTemp.get(c)!=null){
              if(pTemp.get(c)==1){  
                  pTemp.remove(c);
              }else{
                  pTemp.put(c,pTemp.get(c)-1);
              }
          }
      }
      
      if(pTemp.size()==0){
        result.add(i);  
      }
      
      i++;
  }
    return result;
}
}
