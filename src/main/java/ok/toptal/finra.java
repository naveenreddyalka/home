package ok.toptal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class finra {

	public static void main(String[] args) {
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

	//	hs4.entrySet()

		Map<String, Object> hs5 = new HashMap<String, Object>();

		hs5.put("accountNumber", 4073799);

		hs5.put("busSysCode", "CAN");

		hs5.put("isFac", "N");



		input.add(hs1);



		input.add(hs2);



		input.add(hs3);



		input.add(hs4);



		input.add(hs5);
		
		Map<String, String> result = new HashMap<String, String>();
		
		input.stream().filter((map) -> {
			return (map.get("isFac")).toString().equalsIgnoreCase("N") ;
		}).flatMap((map) -> {
			String id = (map.get("accountNumber")).toString();
			String code = (map.get("busSysCode")).toString();
			return Stream.of(new AbstractMap.SimpleEntry<String,String>(id, code));
		}).forEach(ent -> {
			result.put(ent.getKey(),ent.getValue());
		});
		
		System.out.println(result);


	}
}
