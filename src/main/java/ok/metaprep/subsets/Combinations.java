package ok.metaprep.subsets;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Combinations {

  public static List<List<Integer>> combine(int n, int k) {
    Set<Set<Integer>> result = new LinkedHashSet<>();
    Set<Integer> curr = new LinkedHashSet<>();
    fill(curr, n,result,k);
    return convertSetToList(result);
  }


  public static  List<List<Integer>> convertSetToList(Set<Set<Integer>> setOfSets) {
    List<List<Integer>> listOfLists = new ArrayList<>();
    for (Set<Integer> innerSet : setOfSets) {
      listOfLists.add(new ArrayList<>(innerSet));
    }
    return listOfLists;
  }

  public static  void fill(Set<Integer> curr,int n,Set<Set<Integer>> result, int k){
    if(curr.size()==k){
      result.add(new LinkedHashSet<>(curr));
      return;
    }

    for(int i=1; i<=n;i++){
      if(!curr.contains(i)){
        curr.add(i);
        if(curr.size()<=k)
          fill(curr,n,result,k);
        curr.remove(i);
      }
    }

  }

  public static void main(String[] args) {
    printListOfLists(combine(4,2));
  }

  public static void printListOfLists(List<List<Integer>> listOfLists) {
    for (List<Integer> innerList : listOfLists) {
      System.out.println(innerList);
    }
  }
}
