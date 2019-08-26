package ok.demo.old;

public class TapeEquilibrium {

    public static void main(String[] args) {
	int[] a = { -3, 1, -2, 12, 3 };
	int[] b = {-12, -3, -3, -1, -2 };
	int[] c = {-1000, 1000};
 	TapeEquilibrium p = new TapeEquilibrium();
	System.out.println(p.solution(c));
    }

    public int solution(int[] A) {
	int sum = 0;
	for (int i = 0; i < A.length; i++) {
	    sum = sum + A[i];
	}
		
	int min = Integer.MAX_VALUE;
	int lef = 0;
	int rht = sum;
	for (int i = 0; i < A.length-1; i++) {
	    lef = lef + A[i];
	    rht = rht - A[i];
	    int cal = lef - rht;
	    if(cal<0) {
		cal = cal*(-1);
	    }
	    if(min>cal) min = cal;
	}
	return min;
    }

}
