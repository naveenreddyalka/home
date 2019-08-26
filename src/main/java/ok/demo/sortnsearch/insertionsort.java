package ok.demo.sortnsearch;

public class insertionsort {

  public static void main(String[] args) {
    int[] ary = {3,5,1,3,7,98,45};
    sort(ary);
    System.out.println(ary);
  }
  
  private static void sort(int[] ary) {
    
    for(int i=0;i<ary.length-1;i++) {
      
      for(int j=i;j>=0;j--) {
        if(ary[j+1]<ary[j]) {
          int temp = ary[j];
          ary[j] = ary[j+1];
          ary[j+1] = temp;
        }else {
          break;
        }
      }
      
    }
  }
}
