package ok.metaprep.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static List<List<Integer>> findAllSubsets(int[] nums) {

    List<List<Integer>> setsList= new ArrayList<>();
    setsList.add(new ArrayList<>());

    for(int i=0;i<nums.length;i++){
      List<List<Integer>> nextSets= new ArrayList<>();

      for(List<Integer> l:setsList){
        List<Integer> temp = new ArrayList<>(l);
        temp.add(nums[i]);
        nextSets.add(temp);
      }

      for( List<Integer> n : nextSets){
        setsList.add(n);
      }

    }

    return setsList;
  }

  public static void main(String[] args) {
    findAllSubsets(new int[]{1,2,3});
  }

}
