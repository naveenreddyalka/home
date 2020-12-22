package ok.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class srikesh {

	public static void main(String[] args) throws ParseException {
	
	  
	  List<Integer> mate = Arrays.asList(1,2,3,4,8,9);
	  
	  System.out.println(getIndex(mate, 9, 0, mate.size()));
	  System.out.println(getIndex(mate, 9));
	  
	  /*
	  Integer[] targetArray = mate.toArray(new Integer[0]);
	  Set<Integer> targetSet = new HashSet<>(mate);
	  Collections.addAll(targetSet, 1,2,3,4);
	  
	  
	  
	  
	  
	  
	  
	  String s = "2019-07-06T07:23:04+00:00";
		SimpleDateFormat dateFormator = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
		dateFormator.parse(s);
		// System.out.println(getSum(Arrays.asList(4, 5, 6)));

		List<List<Integer>> mat = new ArrayList<List<Integer>>();

		List<Integer> mat1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

		List<Integer> mat2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));

		List<Integer> mat3 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
		mat.add(mat1);
		mat.add(mat2);
		mat.add(mat3);
		
		int[] arr_new = {1};
		int[] arr_new1 = arr_new.clone();
		
		
		
		
		//print(mat);
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		findDiagonalOrder(matrix);
		
		int[] arr = {40,10,20,30};
		List<Integer> a = Arrays.asList(1,2,3,4);
		PriorityQueue<Integer> tst = new PriorityQueue<Integer>(a);
		*/
	}
	
	
	public static int getIndex(List<Integer> array, int value) {
    int low = 0,
        high = array.size();

    while (low < high) {
        int mid = (low + high) /2;
        if (array.get(mid) < value) low = mid + 1;
        else high = mid;
    }
    return low;
}
	public static int getIndex(List<Integer> num, int n, int l, int h) {
	
	  while(l<h) {
	    int mid = (l+h)/2;
	    if(num.get(mid)<n) l=mid+1;
	    else h=mid;
	  }
	  
	  return l;
	}
	
	
	/* public static int getIndex(List<Integer> num, int n, int s, int l){
     int mid = (int)(s + (l-1))/2;
     if(l>s) {
     if(num.get(mid)>n){
          if(mid==0){
              return 0;
          }else if (num.get(mid-1)<n){
              return mid-1;
          }else{
             return getIndex(num,n,s,mid);
          }
     }else if(num.get(mid)<n){
            if(mid==num.size()-1){
                 return num.size();
             }else if (num.get(mid+1)>n){
                 return mid-1;
             }else{
              return getIndex(num,n,mid+1,l);
          }
     }else{
             return mid;
     }
     }
     return -1;
 }*/

	public static int[] findDiagonalOrder(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return new int[0];

		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			int x = i;
			for (int j = 0; j < n; j++) {
				int y = j;

				while (x >= 0 && x < m && y >= 0 && y < n) {
					System.out.println(matrix[x][y]);
					x--;
					y++;
				}
				
			}

		}

		return null;
	}

	public static long getSum(List<Integer> arr) {
		long sum = 0;
		int length = arr.size();

		for (int i = 0; i < length; i++) {
			sum += ((long) arr.get(i) * (long) (i + 1) * (long) (length - i));
		}
		return sum;
	}

	public static void print(List<List<Integer>> matrix) {
		boolean toggle = false;
		for (int i = 0; i < matrix.size(); i++) {

			if (!toggle) {
				for (int j = matrix.get(0).size() - 1; j >= 0; j--) {
					int n = j;
					int m = i;
					while (n < matrix.get(0).size() && n >= 0) {
						if (m < matrix.size() && m >= 0) {
							System.out.println(matrix.get(m).get(n));
							toggle = true;
						} else
							break;
						m++;
						n++;
					}
				}
			} else {

				int n = 0;
				int m = i;
				while (n < matrix.get(0).size() && n >= 0) {
					if (m < matrix.size() && m >= 0) {
						System.out.println(matrix.get(m).get(n));
					} else
						break;
					m++;
					n++;
				}

			}
		}
	}

}
