package ok.demo.old;

public class PermMissingElem {

    public static void main(String[] args) {
	int[] a = {2, 3, 1, 5};
	PermMissingElem p = new PermMissingElem();
	System.out.println(p.solution(a));
    }
    public int solution(int[] A) {
	long sum = 0;
	long length = A.length;
	
	for(int i=0;i<length;i++) {
	    sum = sum+A[i];
	}
	
	return (int)((((length+1)*(length+2))/2) - sum);
    }
}
