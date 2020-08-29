package ok.demo.array;

import java.util.HashMap;
import java.util.Map;

public class Sort3 {

	public static void main(String[] args) {
		Sort3 s = new Sort3();
		int[] a = {1,0,1,1,1,0,2,2,2,0,0,0,2,1};
		//s.sortColors(a);
		System.out.println(a);
		
		int[] b = {3,2,4};
		System.out.println(s.twoSum(b, 6));
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = {-1,-1};
		Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
		int l = nums.length;
		int i = 0;
		
		while(i<l) {
			int a = nums[i];
			int b = target-a;
			if(counts.containsKey(b)) {
				result[0] = counts.get(b);
				result[1] = i;
				return result;
			}else {
				counts.put(a, i);
			}
			i++;
		}
		
		return result;
    }

	
	public void sortColors(int[] nums) {
        int i=0;
		int i0 = 0;
        int i1 = 0;
        
        
        int l = nums.length;
        
        if(l<=1) return;
        
        while(i<l) {
        	if(nums[i]==0) {
        		nums[i] = nums[i0];
        		nums[i0] = 0;
        		i0++;
        		i1++;
        		i++;
        		continue;
        	}
        	
        	if(nums[i]==1) {
        		nums[i] = nums[i1];
        		nums[i1] = 1;
        		i1++;
        		i++;
        		continue;
        	}
        	
        	if(nums[i]==2) {
        		if(nums[l-1] != 2) {
        			nums[i] = nums[l-1];
            		nums[l-1] = 2;
        		}
        		l--;
        	}
        	
        	
        	
        }
    }
}
