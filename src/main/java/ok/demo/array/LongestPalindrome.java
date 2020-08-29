package ok.demo.array;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("a"));
	}

	public static String longestPalindrome(String s) {

		String max = null;

		if (s == null || s.isEmpty() || s.length()==1)
			return s;

		for (int i = 0; i < s.length() - 1; i++) {
			String k = getPalindrome(s, i, i);
			String l = getPalindrome(s, i, i + 1);
			if (max == null)
				max = k.length() > l.length() ? k : l;
			else
				max = (k.length() > l.length() ? k : l).length() > max.length() ? (k.length() > l.length() ? k : l)
						: max;
		}

		return max;
	}

	private static String getPalindrome(String s, int i, int j) {

		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			} else {
				break;
			}
		}

		return s.substring(i + 1, j);
	}
}
