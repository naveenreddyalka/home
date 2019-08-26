package ok.demo.old;

public class MissingInteger {
    public static void main(String[] args) {
	int[] a1 = { 1, 3, 8, 4, 1, 2 };
	int a2[] = { 0, 1, 2, 3, 4, 5, 6, -10, -20 };
	MissingInteger m = new MissingInteger();
	System.out.println(m.solution(a1));

    }

    public int solution(int[] A) {
	int j=0;
	
	for(int i=0;i<A.length;i++) {
	    if(A[i]<=0) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		j++;
	    }
	}
	
	int B[] = new int[A.length-j];
	
	for(int i=j;i<A.length;i++) {
	    B[i-j] = A[i];
	}

	for(int i=0;i<B.length;i++) {
	    if(Math.abs(B[i])-1<B.length && B[Math.abs(B[i])-1]>0) {
		B[Math.abs(B[i])-1] = -B[Math.abs(B[i])-1];
	    }
	}
	
	for(int i=0;i<B.length;i++) {
	    if(B[i]>0) return i+1;
	}
	
	return B.length+1;
    }

}
