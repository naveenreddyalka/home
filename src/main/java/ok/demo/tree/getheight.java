package ok.demo.tree;

public class getheight {

    public static void main(String[] args) {
        // -------7-------
        // ----3------11---
        // --1---5----9---13
        // -n-2-4-6-8-10-12-14
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        node root = buildminbst.getbstNice(test, 0, test.length - 1);
        System.out.println(get(root));
    }
    
    public static int get(node root) {
        if(root==null) return 0;
        return Math.max(get(root.getLeft()), get(root.getRight())) + 1;
    } 
}
