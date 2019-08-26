package ok.demo.sortnsearch;

public class bubblesort {

  public static void main(String[] args) {
    int[] ary = {3,5,1,3,7,98,45};
    sort(ary);
    System.out.println(ary);
  }
  
  private static void sort(int[] ary) {
    
    for(int i=0;i<ary.length-1;i++) {
      
      boolean swapped = false;
      
      for(int j=ary.length-1;j>i;j--) {
        if(ary[j]<ary[j-1]) {
          int temp = ary[j];
          ary[j] = ary[j-1];
          ary[j-1] = temp;
          swapped = true;
        }
      }
      
     if(!swapped) return;
      
    }
  }

  
}
