package ok.demo.tree;

public class sum {

  public static void main(String[] args) {
    // -------7-------
    // ----3------11---
    // --1---5----9---13
    // -n-2-4-6-8-10-12-14
    int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    node root = buildminbst.getbstNice(test, 0, test.length - 1);



    System.out.println(find(root, 13));


  }


  private static boolean find(node head, int sum) {
    if (head == null)
      return false;
    
    if(head.getLeft()==null && head.getRight()==null)
      return sum-head.getValue()==0;
    
     sum = sum - head.getValue();
    
     if(head.getLeft()!=null) {
       boolean l =find(head.getLeft(), sum);
       if(l) return l;
     }
   
     if( head.getRight()!=null){
       boolean r = find(head.getRight(), sum);
       if(r) return r;
     }

    return false;


  }
  
  
  private static boolean find(node head, int sum, String path) {
      if (head == null)
        return false;
      
      if(head.getLeft()==null && head.getRight()==null)
        return sum-head.getValue()==0;
      
       sum = sum - head.getValue();
      
       if(head.getLeft()!=null) {
         boolean l =find(head.getLeft(), sum);
         if(l) return l;
       }
     
       if( head.getRight()!=null){
         boolean r = find(head.getRight(), sum);
         if(r) return r;
       }

      return false;


    }
}
