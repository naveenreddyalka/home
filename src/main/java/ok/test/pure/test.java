package ok.test.pure;

import java.util.Collections;
import java.util.List;

public class test {

	public static void main(String[] args) {
		System.out.println("***");
	
	}
	
	
	
	
	
	

	public static int countPairs(List<Integer> array, int diff) {

		int pairs = 0;
		int len = array.size();
		int i = 0;
		int j = len;
		Collections.sort(array);
		while (i < len) {
			for (j = i; j < len; ++j) {
				if (array.get(j) == array.get(i) + diff) {
					i++;
					pairs++;
					continue;
				}
			}
			i++;
		}

		return pairs;

	}

}
