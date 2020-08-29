package ok.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Pattern {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3,2,4},6)[0] +" "+ twoSum(new int[]{3,2,4},6)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length<=1) return null;
        
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++ ) {
            maps.put(nums[i], i);
        }
        
        List<Integer> numList =  Arrays.stream(nums).boxed().collect(Collectors.<Integer>toList());
        
        Collections.sort(numList);
        int j = numList.size()-1;
        int i = 0;
        while(i!=j) {
            if(numList.get(i) + numList.get(j) == target) {
               
                int[] returnList  = {maps.get(numList.get(i)),maps.get(numList.get(j))};
                
                return returnList;
            }else if(numList.get(i) + numList.get(j) > target) {
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
}
