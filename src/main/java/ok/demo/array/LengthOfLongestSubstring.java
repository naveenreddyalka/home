package ok.demo.array;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcde"));
	}

	public static int lengthOfLongestSubstring(String s) {

		int max = 0;
		if (s == null || s.length() == 0)
			return max;
		int i = 0;
		int j = 0;
		int n = s.length();
		Map<Character, Integer> counts = new HashMap<>();

		while (i < n && j < n) {
			Character c = s.charAt(j);
			if (counts.get(c) != null) {
				if (j - i > max)
					max = j - i;
				int nexti = counts.get(c);
				while (nexti >= i) {
					counts.remove(s.charAt(i));
					i++;
				}
			} else {
				counts.put(c, j);
				j++;
			}
		}

		return Math.max(max, j - i);

	}
}
