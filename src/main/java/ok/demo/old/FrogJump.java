package ok.demo.old;

public class FrogJump {
    public static void main(String[] args) {
	FrogJump f = new FrogJump();
	System.out.println(f.solution(1, 5, 2));
    }
    
    public int solution(int X, int Y, int D) {
	if(X>Y) return 0;
	if(X==Y) return 0;
	return  (Y-X)%D==0? (Y-X)/D : (Y-X)/D + 1;
    }

}
