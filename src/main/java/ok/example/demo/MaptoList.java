package ok.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaptoList {

	public static void main(String args[]) {

		Map<String, List<Integer>> output = new HashMap<String, List<Integer>>();

		List<Map<String, Object>> input = new ArrayList<Map<String, Object>>();

		Map<String, Object> hs1 = new HashMap<String, Object>();
		hs1.put("accountNumber", 4073797);
		hs1.put("busSysCode", "LON");
		hs1.put("isFac", "N");

		Map<String, Object> hs2 = new HashMap<String, Object>();
		hs2.put("accountNumber", 4073798);
		hs2.put("busSysCode", "IND");
		hs2.put("isFac", "N");

		Map<String, Object> hs3 = new HashMap<String, Object>();
		hs3.put("accountNumber", 2073798);
		hs3.put("busSysCode", "US");
		hs3.put("isFac", "Y");

		Map<String, Object> hs4 = new HashMap<String, Object>();
		hs4.put("accountNumber", 2073799);
		hs4.put("busSysCode", "UK");
		hs4.put("isFac", "Y");

		Map<String, Object> hs5 = new HashMap<String, Object>();
		hs5.put("accountNumber", 4073799);
		hs5.put("busSysCode", "CAN");
		hs5.put("isFac", "N");

		input.add(hs1);

		input.add(hs2);

		input.add(hs3);

		input.add(hs4);

		input.add(hs5);

		// input.stream().flatMap(mapper)

		// Map<String,List<Map<String, Object>>> intrim =
		output = input.stream().collect(Collectors.groupingBy(m -> {
			return (String) m.get("isFac");
		})).entrySet().stream().collect(Collectors.toMap(s -> {
			return s.getKey();
		}, v -> {
			v.getValue();
			List<Integer> local = new ArrayList<Integer>();
			v.getValue().forEach(a -> {
				local.add((Integer) a.get("accountNumber"));
			});
			return local;
		}));
		
		

		/*input.stream().collect(Collectors.groupingBy(m -> {
			return (String) m.get("isFac");
		})).entrySet().stream().collect(Collectors.toMap(s -> {
			return s.getKey();
		}, v -> {
			v.getValue().stream().map(e -> {
				e.get("accountNumber");
			}).co;
			return v;
		}));*/

		System.out.println(output);
	}

}
