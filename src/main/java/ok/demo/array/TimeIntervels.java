package ok.demo.array;

import java.util.ArrayList;

public class TimeIntervels {
	
	public static void main(String[] args) {
	    ArrayList<String> strings = new ArrayList<String>();
	
	    for (String string : strings) {
	      System.out.println(string);
	    }
	    
	    int[][] s1 =  {{0,15},{60,100}};
	    int[][] s2 =  {{30,50},{55,90},{95,120}};
	    
	    int[] ret = getCommonAvailability(s1,s2,31);
	    
	     System.out.println(ret[0]);
	     System.out.println(ret[1]);
	    
	    
	  }
	  
	  
	  public static int[] getCommonAvailability(int[][] s1, int[][] s2, int min){
	      
	    int i=0;
	    int j=0;
	    
	    while (i < s1.length && j < s2.length ){
	    System.out.println("in loop "+ i + " " + j);
	    
	      int minEnd = Math.min(s1[i][1], s2[j][1]);
	      System.out.println("min "+ minEnd);
	      int maxStart = Math.max(s1[i][0], s2[j][0]);
	      System.out.println("max "+ maxStart);
	      if((minEnd - maxStart) > 0 && (minEnd - maxStart) >= min){
	          
	          int[] ret = { maxStart , maxStart + min};
	          return ret;
	        
	      }else{
	      
	        if(s1[i][1] < s2[j][1])
	          i++;
	        else 
	          j++;
	      }
	      
	    }
	      
	      /*if((s1[i][0] > s2[j][0]) &&  s1[i][0] <  s2[j][1]){
	      
	        
	        if(
	        
	        int d =  s1[i][0] - s2[j][1];
	         if(d>=min) {
	          int[] ret = { s1[i][0] , s1[i][0] + min};
	          return ret;
	         }
	      }else{
	      
	        if(s1[i][0]  > s2[i][0]){
	          j++;
	        }else{
	          i++;
	        }
	      }
	    }*/
	    
	    
	    return null;
	  }
	  
	  
	  public static int[][] sort(int[][] s){
	   return s; 
	  }
	  
}
