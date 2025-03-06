package ok.metaprep.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
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

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result2 = new ArrayList<>();
    fill2(0,nums,result2);
    return result2;
  }

  static List<Integer> convertArrayToList(int[] arr) {
    List<Integer> list = new ArrayList<>();
    for (int num : arr) {
      list.add(num);
    }
    return list;
  }


  public static void fill2(int index,int[] nums,List<List<Integer>> result){
    if (index == nums.length) {
      result.add(convertArrayToList(nums));
    }
    for(int i=index; i< nums.length-1;i++){
      for(int j=i; j< nums.length-1;j++){
        swap(nums,i,j);
        fill2(index+1,nums,result);
        swap(nums,j,i);
      }
    }
  }

  public static void swap(int[] nums, int i , int j){
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public static void main(String[] args) {
    permuteWord("xyz");
    permute(new int[]{1,2,3});
  }

}
