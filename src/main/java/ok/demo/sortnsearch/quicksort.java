package ok.demo.sortnsearch;

import java.util.Arrays;

public class quicksort {

    public static void main(String[] args) {
        int[] in = {3,4,5,1,3,6,7};
        quicks(in, 0, in.length-1);
        System.out.println(Arrays.toString(in));
        
    }
    
    private static void quicks(int[] arr,int left, int right) {
        int index = partition(arr, left, right);
        
        if(left < index-1 ) {
            quicks(arr,left,index-1);
        }
        
        if(right>index) {
            quicks(arr,index,right);
        }
        
    }
    
    private static int partition(int[] arr,int left, int right) {
           int partion = arr[(left+right)/2];
           while(left<=right) {
               while(arr[left]<partion) left++;
               while(arr[right]>partion) right--;
               
               if(left<=right) {
                   int tmp = arr[left];
                   arr[left] = arr[right];
                   arr[right] = tmp;
                   right--;
                   left++;
               }
           }
           
           return left;
        
    }
    
}
