package ok.demo.array;

import java.util.Arrays;

public class longestsumcontinuous {
    public static void main(String[] args) {
        int[] a = {2,-8,3,-2,4,-10,44};
        int[] b = {-2,11,-4,13,-5,2};
        int r = getlongest(b);
        System.out.println(r);
    }
    
    private static int getlongest(int a[]) {
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<a.length;i++) {
            sum += a[i];
            if(sum>maxSum) {
                maxSum = sum;
            }
            
            if(!(sum>0)) {
                sum = 0;
            }
            
        }
        return maxSum;
    }

}
