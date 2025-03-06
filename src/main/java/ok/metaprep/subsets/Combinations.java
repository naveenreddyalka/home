package ok.metaprep.subsets;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ok.demo.tree.result;

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
    System.out.println("---------------");
    printListOfLists(combine2(4,2));
  }


  public static List<List<Integer>> combine2(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    fill2(1,n,k,new ArrayList<>(),result);
    return result;
  }

  public static void fill2(int idx, int n, int k, List<Integer> curr, List<List<Integer>>result) {
   if(curr.size()==k){
     result.add(new ArrayList<>(curr));
     return;
   }

   for(int i=idx; i<=n; i++){
     curr.add(i);
     fill2(i+1,n,k,curr,result);
     curr.remove(curr.size()-1);
   }

  }


  public static void printListOfLists(List<List<Integer>> listOfLists) {
    for (List<Integer> innerList : listOfLists) {
      System.out.println(innerList);
    }
  }
}
