package ok.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class srikesh {

	
	public static void main(String[] args) throws ParseException {
		String s = "2019-07-06T07:23:04+00:00";
		  SimpleDateFormat dateFormator = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
		  dateFormator.parse(s);
		//System.out.println(getSum(Arrays.asList(4, 5, 6)));
		
		List<List<Integer>> mat  = new ArrayList<List<Integer>>();
		
		List<Integer> mat1  = new ArrayList<Integer>( 
	            Arrays.asList(1, 
                        2, 
                        3));
		
		List<Integer> mat2  = new ArrayList<Integer>( 
	            Arrays.asList(4, 
                        5, 
                        6));
		
		List<Integer> mat3  = new ArrayList<Integer>( 
	            Arrays.asList(7, 
                        8, 
                        9));
		mat.add(mat1);
		mat.add(mat2);
		mat.add(mat3);
		
		print(mat);
	}

	public static long getSum(List<Integer> arr) {
		long sum = 0;
        int length = arr.size();
        
        for(int i =0; i < length; i++) {
            sum += ((long)arr.get(i) * (long)(i+1) * (long)(length - i));
        }
        return sum;
	}
	
	public static void print(List<List<Integer>> matrix) {
		boolean toggle = false;
		for(int i=0;i<matrix.size(); i++) {
			
			if(!toggle) {
				for(int j=matrix.get(0).size()-1; j>=0 ;j--) {
					int n = j;
					int m = i;
					while(n<matrix.get(0).size() && n>=0) {
						if(m<matrix.size() && m>=0) {
							System.out.println(matrix.get(m).get(n));
							toggle= true;
						}
						else
							break;
						m++;
						n++;
					}
				}
			}else {
				
					int n = 0;
					int m = i;
					while(n<matrix.get(0).size() && n>=0) {
						if(m<matrix.size() && m>=0) {
							System.out.println(matrix.get(m).get(n));
						}
						else
							break;
						m++;
						n++;
					}
				
				
			}
		}
	}

}
