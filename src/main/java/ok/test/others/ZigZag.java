package ok.test.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigZag {

	public static void main(String[] args) {
		//System.out.println(convert("PAYPALISHIRING", 3));
		String[] strs = {"aaa","aaa","aa"};
		System.out.println(findLUSlength(strs));

	}

	public static String convert(String s, int numRows) {

		List<List<Character>> results = new ArrayList<List<Character>>();

		if (numRows <= 1)
			return s;

		for (int i = 0; i < numRows; i++) {
			List<Character> st = new ArrayList<Character>();
			results.add(st);
		}

		int i = 0;
		int roll = 0;
		boolean toggle = true;
		while (i < s.length()) {

			results.get(roll).add(s.charAt(i));
			i++;
			if(toggle) {
				roll++;
				if (roll == numRows-1) {
					toggle= false;
				}
			}else {
				roll--;
				if(roll == 0) toggle=true;
			}
			

		}

		StringBuilder sb = new StringBuilder();
		for (List<Character> cl : results) {
			for (Character c : cl) {
				sb.append(c);
			}
		}

		return sb.toString();
	}
	
	public static int findLUSlength(String[] strs) {
		
		Map<String,Integer> mapOf = new HashMap<String, Integer>();
		
		for(int i=0;i<strs.length;i++) {
			List<String> results = subsequence(strs[i]);
			for(String str : results) {
				if(!mapOf.containsKey(str)) {
					mapOf.put(str, 1);
				}else {
					mapOf.put(str, mapOf.getOrDefault(str, 0)+1);
				}
		}
		}
        int max = -1;
		for(String str :  mapOf.keySet()) {
			if(mapOf.get(str)==1) {
				max = Math.max(max, str.length());
			}
		}
		
		return max;
    }
	
	public static List<String> subsequence(String str){
		List<String> results = new ArrayList<String>();
		if(str.length()==1) {
			results.add(str);
			return results;
		}
		results = subsequence(str.substring(1));
		List<String>  add = new ArrayList<String>();
		
		for(String s : results) {
			add.add(str.substring(0,1)+ s);
		}
		
		add.add(str.substring(0,1));
		
		results.addAll(add);
		
		return results;
	}
}
