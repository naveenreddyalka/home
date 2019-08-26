package ok.demo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class makeChange {

    public static void main(String[] args) {
     int[] coins = {1,2,5,10,20,25};
     //int[] coins = {1,2,5};
       // System.out.println(make(coins, new HashMap<Integer, Integer>(), 4));
         List<List<Integer>> all = new ArrayList<List<Integer>>();
        System.out.println(make(coins, 5,new ArrayList<Integer>(),all));
        System.out.println(all);
    }
    
    private static int make(int[] coins,Map<Integer, Integer> val,int k) {
        if(k<0) return -1;
        if(k==0) return 0;
        
        if(val.get(k)!=null && val.get(k)!=(-1)) return val.get(k);
        
        int min = -1;
        for(int i=0;i<coins.length;i++) {
             int interm = make(coins,val,k-coins[i]);
             if(interm!=-1 ) {
                 if(min == -1) min = interm;
                 else min = Math.min(min, interm);
             } 
        }
        
        val.put(k, min+1);
        
        return min+1;
    }
    
    private static int make(int[] coins,int amount) {
        if(amount<0) return -1;
        if(amount==0) return 0;
        int count = 0;
        for(int i=0;i<coins.length;i++) {
            int interm = make(coins,amount-coins[i]);
            if(interm!=-1) count = count+1;
        }
        return count;
    }
    
    private static int make(int[] coins,int amount,List<Integer> conbination, List<List<Integer>> all) {
        if(amount<0) return -1;
        if(amount==0) { 
            if(all==null) all = new ArrayList<List<Integer>>();
            List<Integer> clone = new ArrayList<Integer>();
            clone.addAll(conbination);
            all.add(clone);
            //System.out.println(conbination);
            return 1;
            }
        int count = 0;
        for(int i=0;i<coins.length;i++) {
            conbination.add(coins[i]);
            int interm = make(coins,amount-coins[i],conbination,all);
            conbination.remove(conbination.size()-1);
            if(interm!=-1) {
                count = count+interm;
            }
        }
        
        return count;
    }
    
}
