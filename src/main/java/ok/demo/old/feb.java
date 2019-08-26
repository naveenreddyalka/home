package ok.demo.old;

public class feb {

    public static void main(String[] args) {
        int n = 10;
        int first = 1;
        int second =1;
        //System.out.println(first);
        //System.out.println(second);
        for(int i=0;i<n-2;i++) {
            int temp = first;
            first = first + second;
            second = temp;
        }
        System.out.println(first);
        
    }
}
    