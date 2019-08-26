package ok.demo.tree;

public class isbalanced {

    public static void main(String[] args) {
        // -------7-------
        // ----3------11---
        // --1---5----9---13
        // -n-2-4-6-8-10-12-14
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        node root = buildminbst.getbstNice(test, 0, test.length - 1);
        System.out.println(check(root)); 
    }
    
    public static Boolean check(node root) {
        
        if(root==null) return true;
        
        int diff = getheight.get(root.getLeft()) - getheight.get(root.getRight());
        
        if(Math.abs(diff) > 1) {
            return false;
        }else {
            return check(root.getLeft()) && check(root.getRight());
        }
    }
}
