package ok.demo.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GroupBy {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<Integer>();
		
		for(int i =0 ; i<1200 ; i++) {
			nums.add(i);
		}
		
		int[] count = new int[1];
		Map<Integer, List<Integer>> chunkedKeys = nums.stream().collect(Collectors.groupingBy(k -> {
			count[0]++;
			return Math.floorDiv(count[0], 10);
		}));
		
		System.out.println(chunkedKeys);
	}
}
