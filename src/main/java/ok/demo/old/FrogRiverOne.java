package ok.demo.old;

public class FrogRiverOne {
    public static void main(String[] args) {
	FrogRiverOne f = new FrogRiverOne();
	int[] a = {1,2,3,4,5,6,7,8,9};
	System.out.println(f.solution(5, a));;
    }

    public int solution(int X, int[] A) {
	int[] B = new int[X+1];
	int count = 0;
	int reach = X*(X+1)/2;
	for(int i=0;i<A.length;i++) {
	    if(A[i]<=X && B[A[i]]!=-1) {
		count = count+A[i];
		B[A[i]] = -1;
	    }
	    if(count == reach) return i;
	}
	return -1;
    }
}
