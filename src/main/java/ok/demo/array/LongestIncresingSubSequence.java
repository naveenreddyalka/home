package ok.demo.array;

import java.util.Arrays;

public class LongestIncresingSubSequence {

    public static void main(String[] args) {
        int[] a = {10,1,2,3,4,0};
        int[] r = getlongest(a);
        System.out.println(Arrays.toString(r));
        System.out.println(getlongestDP(a,a.length) ); 
    }

    private static int getlongestDP(int a[],int n) {
        int[] st = new int[n];
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
        
    
    private static int[] getlongest(int a[]) {
        int[][] r = new int[a.length][a.length];
        //r[0] = new int[r.length];
        r[0][0] = a[0];           
      
        int[] maxV = new int[r.length];
        int max = 0;
        
        for (int i = 1; i < a.length; i++) {
            int[] intrim = findMaxAtN(r, a[i], i);
            if (intrim.length > max) {
                max = intrim.length;
                maxV = intrim;
            }
        }
        return maxV;
    }

    private static int[] findMaxAtN(int[][] r, int a, int n) {
        int maxAt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int non = getNonZero(r[i]);
            if (r[i].length > 0 && r[i][non] < a) {
                r[i][non+1] = a;
                if (r[i].length > max) {
                    maxAt = i;
                    max = r[i].length;

                }
            }
        }
        return r[maxAt];
    }
    
    private static int getNonZero(int[] r) {
        for(int i = r.length-1;i>=0;i--) {
            if(r[i]>0) return i;
        }
        return 0;
    }
}
