package ok.demo.sortnsearch;

public class mergesort {

    public static void main(String[] args) {
        int[] test = {9,1,2,3,4,5,6,7,8};
        
        mergeSort(test, new int[test.length], 0, test.length-1);
        
        System.out.println(test);
    }
    
    public static void mergeSort(int[] arr,int[] help, int l,int h) {
        if(l<h) {
            int m = (l+h)/2;
            mergeSort(arr, help, l, m);
            mergeSort(arr, help, m+1, h);
            merge(arr, help, l,m, h);
        }
    }
    private static void merge(int[] arr,int[] help, int l,int m,int h) {
        for(int i=l;i<=h;i++) {
            help[i] = arr[i];
        }
        
        int help_l = l;
        int help_r = m+1;
        int arr_c=l;
        
        while(help_l<=m && help_r<=h) {
            if(help[help_l]<=help[help_r]) {
                arr[arr_c] = help[help_l];
                help_l++;
            }else {
                arr[arr_c] = help[help_r];
                help_r++;
            }
            arr_c++;
        }
        
        int left = m -help_l;
        for(int i=0;i<=left;i++) {
            arr[arr_c+i] = help[help_l+i];
        }
    }
}
