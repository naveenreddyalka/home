package ok.demo.array;

public class LongestCommonSubSequenceAndSubString {

    private static int[][] store  = new int[99][100];
    private static String longest  ="";
    
    
    public static void main(String[] args) {
        getLongString("ABCcccBDBF","A1111BF",0,"ABCcccBDBF".length(),0,"A1111BF".length());
        System.out.println(getLongStringDP("ABCcccBDBF","A1111BF","ABCcccBDBF".length(),"A1111BF".length()));
        System.out.println(longest); 
        System.out.println(getLongSub("ABCcccBDBF","A1111BF",0,0));
       
        System.out.println(getLongSubDP("ABCcccBDBF", "A1B111F")); 
        
    }
    
    private static void getLongString(String p1,String p2,int i,int j,int k,int l) {
        if(i==j || k==l) {
            return ;
        }
        
        if(p1.substring(i,j).equals(p2.substring(k,l))) {
            if(longest.length()<p1.substring(i,j).length()) {
                longest = p1.substring(i,j);
            }
        }else {
            getLongString(p1, p2, i+1, j,k,l);
            getLongString(p1, p2, i, j-1,k,l);
            getLongString(p1, p2, i, j,k+1,l);
            getLongString(p1, p2, i, j,k,l-1);
        }
    }
    private static int getLongStringDP(String p1,String p2,int k,int l) {
        int LCStuff[][] = new int[k + 1][l + 1]; 
        int result = 0;  // To store length of the longest common substring 
          
        // Following steps build LCSuff[m+1][n+1] in bottom up fashion 
        for (int i = 0; i <= k; i++)  
        { 
            for (int j = 0; j <= l; j++)  
            { 
                if (i == 0 || j == 0) 
                    LCStuff[i][j] = 0; 
                else if (p1.charAt(i - 1) == p2.charAt(j - 1)) 
                { 
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1; 
                    result = Integer.max(result, LCStuff[i][j]); 
                }  
                else
                    LCStuff[i][j] = 0; 
            } 
        } 
        return result; 
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
