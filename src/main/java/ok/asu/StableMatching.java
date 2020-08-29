package ok.asu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class StableMatching {

	// given
	public static List<List<Integer>> men = new ArrayList<List<Integer>>();
	public static List<List<Integer>> women = new ArrayList<List<Integer>>();
	public static List<Integer> men_max = new ArrayList<Integer>();

	// init
	public static List<List<Integer>> women_inverse = new ArrayList<List<Integer>>();
	public static List<Integer> men_propose_count = new ArrayList<Integer>();
	public static Queue<Integer> men_free = new LinkedList<Integer>();
	public static Map<Integer, Integer> women_pair = new HashMap<Integer, Integer>();
	public static Map<Integer, List<Integer>> men_pair = new HashMap<Integer, List<Integer>>();

	static {
		
		List<Integer> men1 =  new ArrayList<Integer>(Arrays.asList(0,1,2/*,3,4*/));
		List<Integer> men2 =  new ArrayList<Integer>(Arrays.asList(1,2,0/*,3,4*/));
		List<Integer> men3 =  new ArrayList<Integer>(Arrays.asList(0,1,2/*,3,4*/));
		//List<Integer> men4 =  new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
		//List<Integer> men5 =  new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
		men.add(men1);men.add(men2);men.add(men3);//men.add(men4);men.add(men5);
		List<Integer> women1 =  new ArrayList<Integer>(Arrays.asList(2,1,0/*,3,4*/));
		List<Integer> women2 =  new ArrayList<Integer>(Arrays.asList(0,2,1/*,3,4*/));
		List<Integer> women3 =  new ArrayList<Integer>(Arrays.asList(0,1,2/*,3,4*/));
		//List<Integer> women4 =  new ArrayList<Integer>(Arrays.asList(0,1,2/*,3,4*/));
		//List<Integer> women5 =  new ArrayList<Integer>(Arrays.asList(0,1,2/*,3,4*/));
		//List<Integer> women6 =  new ArrayList<Integer>(Arrays.asList(0,1,2/*,3,4*/));
		women.add(women1);women.add(women2);women.add(women3);//women.add(women4);women.add(women5);
		//women.add(women6);
		
		
		for(int i=0;i<men.size();i++) {
			men_propose_count.add(i,0);
			men_free.add(i);
			men_pair.put(i, new ArrayList<Integer>());
			men_max.add(1);
		}
		
		for(int i=0;i<women.size();i++) {
			
			women_pair.put(i, -1);
			List<Integer> inverse = new ArrayList<Integer>();
		
			//dummy set
			inverse.addAll(women.get(i));
		
			for(int j=0;j<women.get(i).size();j++) {
				inverse.set(women.get(i).get(j),j);
			}
			women_inverse.add(inverse);
		}
	}
	
	public static void main(String[] args) {
		match();
		System.out.println(men_pair);
	}
	
	public static void match() {
		while(!men_free.isEmpty()) {
			int m = men_free.poll();
			int w = men.get(m).get(men_propose_count.get(m));
			
			if(women_pair.get(w)==-1) {
				women_pair.put(w, m);
				men_pair.get(m).add(w);
				men_propose_count.set(m, men_propose_count.get(m)+1);
			
			}else if(women_inverse.get(w).get(women_pair.get(w)) > women_inverse.get(w).get(m)) {
				
				int old_m = women_pair.get(w);
				
				women_pair.put(w, m);
				men_pair.get(m).add(w);
				men_propose_count.set(m, men_propose_count.get(m)+1);
				
				men_pair.get(old_m).remove(men_pair.get(old_m).indexOf(w));
				
				if(men_pair.get(old_m).size()<men_max.get(old_m)) {
					men_free.add(old_m);
				}
			
			}else {
				men_propose_count.set(m, men_propose_count.get(m)+1);
			}
			
			if(men_pair.get(m).size()<men_max.get(m)) {
				men_free.add(m);
			}
		}
	}
}
