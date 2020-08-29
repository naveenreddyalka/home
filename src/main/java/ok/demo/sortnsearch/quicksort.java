package ok.demo.sortnsearch;

import java.util.Arrays;

public class quicksort {

    public static void main(String[] args) {
        int[] in = {3,2,1,5,6,4};
        System.out.println(pickKthLargest(in,0,in.length,2));
        
        
        quicks(in, 0, in.length-1);
        System.out.println(Arrays.toString(in));
        
    }
    public static int pickKthSmallest(int[] nums,int i,int j,int k){
        
        if(k>0 && k<(j-i+1)){
            int p = sortForSmallest(nums,i,j);
            if(p-i==k-1){
                return nums[p];
            }else if(p-i > k-1){
                return pickKthSmallest(nums,i,p,k);
            }else{
                return pickKthSmallest(nums,p+1,j,k-p+i-1);
            }
            
        }
        
        return -1;
    }
    
    public static int pickKthLargest(int[] nums,int i,int j,int k){
        
        if(k>0 && k<(j-i+1)){
            int p = sortForLargest(nums,i,j);
            if(p-i==k-1){
                return nums[p];
            }else if(p-i > k-1){
                return pickKthLargest(nums,i,p,k);
            }else{
                return pickKthLargest(nums,p+1,j,k-p+i-1);
            }
            
        }
        
        return -1;
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
    
    public static int sortForSmallest(int[] nums,int i,int j){
        
        int p = nums[j-1];
        int k = i;
        for(;i<j;i++){
            if(nums[i] < p){
               int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    
            int temp = nums[k];
            nums[j-1] = temp;
            nums[k] = p; 

        
    return k;
    }
    
    public static int sortForLargest(int[] nums,int i,int j){
        
        int p = nums[j-1];
        int k = i;
        for(;i<j;i++){
            if(nums[i] > p){
               int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    
            int temp = nums[k];
            nums[j-1] = temp;
            nums[k] = p; 

        
    return k;
    }
    
    

    
}
