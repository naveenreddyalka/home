package ok.demo.array;

public class longestcommonsubsequence {

    private static int[][] store  = new int[99][100];
    
    
    public static void main(String[] args) {
         System.out.println(getLongSub("ABCcccBDBF","A1111BF",0,0));
        System.out.println(getLongSubDP("ABCcccBDBF", "A1B111F")); 
        
    }
    
    private static String getLongSub(String p1,String p2,int i,int j) {
        if(i==p1.length() || j==p2.length()) {
            return "";
        }
        
        if(p1.charAt(i) == p2.charAt(j)) {
            return p1.charAt(i) + getLongSub(p1, p2, i+1, j+1);
        }else {
            String sub1 = getLongSub(p1, p2, i, j+1);
            String sub2 = getLongSub(p1, p2, i+1, j);
            return sub1.length()>sub2.length()?sub1:sub2;
        }
    } 
    
    private static int getLongSubDP(String p1,String p2) {
       
        for(int l=0;l<=p1.length();l++) {
            store[p1.length()][l] =0;
        }
        
        for(int l=0;l<=p2.length();l++) {
            store[l][p1.length()] =0;
        }
        
        for(int l=p1.length()-1;l>=0;l--) {
            for(int j=p2.length()-1;j>=0;j--) {
                store[l][j] = store[l+1][j+1];
                
                if(p1.charAt(l)==p2.charAt(j)) store[l][j]  = store[l][j]+1;
                else store[l][j] = Math.max(store[l][j],Math.max(store[l][j+1], store[l+1][j]));
            }
        }
        
        return store[0][0];
    }
}
