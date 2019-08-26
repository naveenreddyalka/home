package ok.demo.old;

public class Rotate {
    public static void main(String[] args) {
	Rotate r = new Rotate();
	r.solution(new int[] { 1, 8, 27, 64, 125, 216, 343 }, 1);
    }
    

    public int[] solution(int[] A, int K) {
	if(A==null || A.length==0) {
	    return A;
	}
	int[] R = new int[A.length];
	int m = K%A.length;
	int start = A.length-m;
	int r =0;
	for(int i = start;i<A.length;i++) {
	    R[r]=A[i];
	    r++;
	}
	for(int i = 0;i<start;i++) {
	    R[r]=A[i];
	    r++;
	}
	return R;
    }
}
