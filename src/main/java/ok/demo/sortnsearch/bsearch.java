package ok.demo.sortnsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bsearch {

    public static void main(String[] args) {

        int[] test = { 9, 1, 2, 4, 5, 6, 7 };

        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(-33);
        in.add(-10);
        in.add(0, 9);

        mergesort.mergeSort(test, new int[test.length], 0, test.length - 1);

        System.out.println(search(test, 100));
    }

    public static int search(int[] arr, int a) {
        int l = 0;
        int h = arr.length;
        int m = l + h / 2;

        while (m > 0 && m<arr.length) {         
            if (arr[m] > a) {
                m = m / 2;
            } else if (arr[m] < a) {
                m = m + (m / 2);
            } else {
                return m;
            }
        }

        return -1;
    }
    
    public static int bsearch2(int[] arr, int a) {
      int l=0;
      int h=arr.length-1;
      while(h>l) {
        int m = ((h+l)+1)/2;
        if(arr[m]>a) {
          h = m;
        }else if(arr[m]<a) {
          l = m;
        }else {
          return m;
        }
      }
      return -1;
    }
}
