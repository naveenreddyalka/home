package ok.demo.array;

public class CheckSubSeq {

    public static void main(String[] args) {
        System.out.println(checkSub("ADXCPY", "AXY"));
    }
    
    private static boolean checkSub(String big,String b) {
        int x=0;
        int y=0;
        for(;x<big.length();x++) {
            if(big.charAt(x) == b.charAt(y)) {
                y++;
            }
        }
        
        if(y==b.length()) return true;
        else return false;
    }
}
    