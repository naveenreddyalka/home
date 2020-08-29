package ok.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeIntervels {
	public static void main(String[] args) {
		int[][] a = {{1,4},{0,4}};
		merge(a);
	}
	
	public static int[][] merge(int[][] intervals) {
		Stack<List<Integer>> temp = new Stack<List<Integer>>();
		Stack<List<Integer>> res = new Stack<List<Integer>>();
		int l = intervals.length;
		for(int i=0;i<l;i++) {
			temp.add(Arrays.asList(intervals[i][0],intervals[i][1]));
		}
		
		temp.sort((o1,o2) -> {
			return o1.get(0).compareTo(o2.get(0));
		});
		
		for(int i=0; i<temp.size();i++ ) {
			intervals[i][0] = temp.get(i).get(0);
			intervals[i][1] = temp.get(i).get(1);
		}
		
		
		for(int i=0;i<l;i++) {
			if(res.isEmpty()) {
				res.push(Arrays.asList(intervals[i][0],intervals[i][1]));
			}else {
				List<Integer> top = res.peek();
				if(top.get(1)>=intervals[i][0]) {
					if(top.get(1)<=intervals[i][1]) {
						top.set(1, intervals[i][1]);
					}
				}else {
					res.push(Arrays.asList(intervals[i][0],intervals[i][1]));
				}
			}
		}
		int[][] retArray = new int[res.size()][2];
		
		for(int i=0; i<res.size();i++ ) {
			retArray[i][0] = res.get(i).get(0);
			retArray[i][1] = res.get(i).get(1);
		}
		
		return retArray;
        
    }
}
