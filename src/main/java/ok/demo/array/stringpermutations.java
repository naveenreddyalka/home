package ok.demo.array;

import java.util.ArrayList;
import java.util.List;

public class stringpermutations {

    public static void main(String[] args) {
        List<String> stL = getAllPerm("abc");
        perm("abc", "");
        
    }

    private static void perm(String pre,String str) {
        if (str == null || str.length() == 0)
            System.out.println(pre);
        else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                perm(pre + str.charAt(i),rem);
            }
        }
    }

    private static List<String> getAllPerm(String str) {
        if (str == null)
            return new ArrayList<String>();
        if (str.length() == 0) {
            List<String> all = new ArrayList<String>();
            all.add("");
            return all;
        }else {
            String first = String.valueOf(str.charAt(0));
            String rest = str.substring(1);
            List<String> restperms = getAllPerm(rest);
            List<String> combined = new ArrayList<String>();
            for(String perm : restperms) {
                for(int i=0;i<=perm.length();i++) {
                    String next = perm.substring(0, i) + first + perm.substring(i);
                    combined.add(next);
                }
            }
            
            return combined;
            
        }
        
    }
}
