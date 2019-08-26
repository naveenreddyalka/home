package ok.demo.array;

import java.util.Arrays;

public class MinWindow {
    
    public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
    
    public static String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }

        char key[]  = t.toCharArray();
        String tKey = String.valueOf(key);
        
        int min = -1; int minL=-1, minR =-1;
        
        int l=0,r =0;
        
        while(r<s.length()) {
            char temp[]  = s.substring(l, r).toCharArray();
            Arrays.sort(temp);
            
            while(l<r && String.valueOf(temp).contains(tKey)) {
                
                if(min==-1 || min < (r-l)) {
                    min = r-l;
                    minL=l;
                    minR=r;
                }
                l++;
                temp = s.substring(l, r).toCharArray();
                Arrays.sort(temp);
            }
            
            r++;
        }
       
        return min == -1 ? "" : s.substring(minL, minR);
       }
    
}
