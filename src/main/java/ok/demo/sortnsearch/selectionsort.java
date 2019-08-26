package ok.demo.sortnsearch;

public class selectionsort {
  public static void main(String[] args) {
    int[] ary = {3,5,1,3,7,98,45};
    sort1(ary, 0);
    System.out.println(ary);
  }
  
  private static void sort(int[] ary,int index) {
    if(index == ary.length-1) return;
    
    int min = ary[index];
    int minindex = -1;
    for(int i=index+1;i<ary.length;i++) {
      if(ary[i]<min) {
        min = ary[i];
        minindex = i;
      }
    }
    if(minindex!=-1) {
      int temp = ary[index];
      ary[index] = ary[minindex];
      ary[minindex] = temp;
    }
    sort(ary, index+1);
  }
  
  private static void sort1(int[] ary,int index) {
    if(index == ary.length-1) return;
    for(int i=index+1;i<ary.length;i++) {
      if(ary[i]<ary[index]) {
        int temp = ary[index];
        ary[index] = ary[i];
        ary[i] = temp;
      }
    }
    sort1(ary, index+1);
  }

}
