package ok.demo.old;

public class PremCheck {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,10};
        PremCheck p = new PremCheck();
        System.out.println(p.solution(a));
     }
    public int solution(int[] A) {
        int[] B = new int[A.length];
        for(int i=0;i<A.length;i++) {
           if(A[i]<=A.length) {
               B[A[i]-1] = 1;
           }
        }
        
        for(int i=0;i<A.length;i++) {
            if(B[i]!=1) return 0;
         }
        return 1;
    }

}
