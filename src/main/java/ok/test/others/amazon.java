package ok.test.others;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class amazon {

	public static void main(String[] args) {
		String s1 = "19a 1 mdsa dsam mdsa";	
		String s2 = "18a 1 mdsa dsam mdsa";		
		String s1p = s1.substring(s1.indexOf(" ")+1);
		String s2p = s1.substring(s1.indexOf(" "));
		String p = s1.substring(0,s1.indexOf(" "));
		
		byte[] ascii = "a 2 3".getBytes(StandardCharsets.US_ASCII);
		String asciiString = Arrays.toString(ascii);

		System.out.println(new String(ascii));	
			
		System.out.println(s1.split(" ")[1]);
		List<String> dig = new ArrayList<>();
		
		dig.add(s1);
		dig.add(s2);
		
		Collections.sort(dig, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String s1p = s1.substring(s1.indexOf(" ")+1);
				String s2p = s2.substring(s2.indexOf(" ")+1);
				int r =  s1p.compareTo(s2p);
				if(r==0) {
					r = s1.substring(0,s1.indexOf(" ")).compareTo(s2.substring(0,s2.indexOf(" ")));
				}
				
				return r;
			}
		});
		System.out.println(p);
	}
	
	

	static int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		
		if(rows ==0 || column==0) return 0;
		if(grid==null) return 0;
		int count = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<column;j++) {
				if(grid.get(i).get(j)==1) {
					dfs(grid, rows, column, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	static void dfs(List<List<Integer>> grid,int rows, int column,int i, int j) {
		
		if(i<0 || j<0 || i>=rows || j>= column || grid.get(i).get(j)==0)
			return;
		
		grid.get(i).set(j, 0);
		
		dfs(grid, rows, column, i+1, j);
		dfs(grid, rows, column, i, j+1);
		dfs(grid, rows, column, i-1, j);
		dfs(grid, rows, column, i, j-1);
		
	}
	
	
	public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		
		if(logLines==null || logLines.size()==0) return logLines;
		
		List<String> alp = new ArrayList<>();
		List<String> dig = new ArrayList<>();
		
		
		for(String a : logLines) {
			String[] sp = a.split(" ");
			if(isNumeric(sp[1])) {
				dig.add(a);
			}else {
				alp.add(a);
			}
		}
		List<String> res = new ArrayList<String>();
		
		
		if(alp!=null && !alp.isEmpty()) {
			Collections.sort(alp, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					String s1p = s1.substring(s1.indexOf(" ")+1).toLowerCase();
					String s2p = s2.substring(s2.indexOf(" ")+1).toLowerCase();
					
					String p1 = s1.substring(0,s1.indexOf(" "));
					String p2 = s2.substring(0,s2.indexOf(" "));
					
					int r =  s1p.compareTo(s2p);
					
					if(r==0) {
						r = p1.compareTo(p2);
					}
					
					return r;
				}
			});
			res.addAll(alp);
		}
		
		if(dig!=null && !dig.isEmpty()) {
			res.addAll(dig);
		}
		
		return res;
	}
	
	boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	
	

}
