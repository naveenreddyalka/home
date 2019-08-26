package ok.demo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class longestincresingsubsequenceList {

    public static int[] st = new int[1000];
    public static void main(String[] args) {
        int[] a = {-44, 2, -8, 3, 5,-2, 7, -10 };
        int[] b = {3,2,1,4};
        List<Seq> x= getlongest(IntStream.of(a).boxed().collect(Collectors.toList()),a.length);
        System.out.println(x);
        
        System.out.println(getLongestDP(a, a.length));
    }

    private static List<Seq> getlongest(List<Integer> a,int size) {
        
        List<Seq> all = new ArrayList<Seq>();
       
        if (size == 1) {
            Seq s = new longestincresingsubsequenceList.Seq();
            List<Integer>  r = new ArrayList<Integer>();
            r.add(a.get(0));
            s.sq = r;
            s.end = 0;
            all.add(s);
            return all;
        }
        
        Integer last = a.get(size-1);
        //if(save.get(a.size())!=null) 
        List<Seq> rest = getlongest(a,size-1);
        int maxS = -1;
        for(Seq s : rest) {
            if(a.get(s.end)<last) {
                s.sq.add(last);
                if(s.sq.size()>=maxS) {
                     maxS = s.sq.size();
                }
                s.end = s.end+1;
            }else {
                maxS = Math.max(maxS,s.sq.size());
            }
        }
        
        if(maxS==1) {
            Seq s = new longestincresingsubsequenceList.Seq();
            List<Integer>  r = new ArrayList<Integer>();
            r.add(last);
            s.sq = r;
            s.end = size-1;
            rest.add(s);
         }
        
        List<Seq> result = new ArrayList<Seq>();
        for(Seq s : rest) {
            if(s.sq.size()==maxS) {
                result.add(s);
            }
        }
        
        
        return result;
    }
    
    static class Seq{
        public List<Integer> sq = new ArrayList<Integer>();
        public Integer end = -1;
    }
    
    private static int getLongestDP(int[] a,int n) {
        for(int i =0;i<n;i++)
            st[i]=1;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(a[i] > a[j] && st[i] < st[j]+1) {
                    st[i] = st[j]+1;
                }
            }
        }
        int max = -1;
        for(int i=0;i<n;i++) {
            if(st[i]>max) max = st[i];
        }
        
        return max;
    }
    
}
