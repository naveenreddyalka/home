package ok.test;

import java.text.ParseException;
import java.util.Arrays;

public class srikesh2 {
  /*
   *        
   * [8,5,6,2,11], K=2
   *
   *
   *
   */
  public static void main(String[] args) throws ParseException {
    int[] in = { 8, 5, 6, 2, 11 };

    System.out.println(Arrays.toString(getLex(in, 2)));

  }
// 1,2,3,4 , k=2 
  
  /*
   * cmin = 0, s =0 
   * k =2 
   * 
   * cmin = 1, s =1
   * k =2
   * 
   */


  public static int[] getLex(int[] in, int k) {
    
    int cmin = -1;
    int s = 0;
   
    while(k>=0 && s<in.length) {
      cmin = getMinIndex(in,s,k);
    
      k = k - (cmin-s);
      
      while(cmin-s>0) {
        in = swap(in, cmin-1, cmin);
        cmin--;
      }
      
      s++;
    }
    
    return in;
  }
  
  public static int[] swap(int[] in, int i, int j) {
    int temp = in[j];
    in[j] = in[i];
    in[i] = temp;
    return in;
  }
  
  public static int getMinIndex(int[] in, int s, int n) {
    
    int min = Integer.MAX_VALUE;
    int minI = -1;
    for(int i=s;i<n;i++) {
      if(in[s]<min) {
        min = in[s];
        minI=i;
      }
    }
    
    return minI;
  }
  
  
}
