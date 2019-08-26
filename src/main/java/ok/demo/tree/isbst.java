package ok.demo.tree;

public class isbst {
    public static void main(String[] args) {
        // -------7-------
        // ----3------11---
        // --1---5----9---13
        // -n-2-4-6-8-10-12-14
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        node root = buildminbst.getbstNice(test, 0, test.length - 1);
        System.out.println(isbstCorrect(root,null,null));
    }

    public static boolean isbst(node root) {
        if(root==null) return true;
        
        if(root.getLeft()!=null) {
            return root.getValue()>root.getLeft().getValue();
        }
        
        if(root.getRight()!=null) {
            return root.getValue()<root.getRight().getValue();
        }
        
        return isbst(root.getLeft()) && isbst(root.getRight());
     }
    
    public static boolean isbstCorrect(node root, Integer min, Integer max) {
        if(root==null) return true;
        
        if((min!=null && min > root.getValue()) && (max!=null && max < root.getValue())) {
            return false;
        }
        
        return isbstCorrect(root.getLeft(), min, root.getValue()) && isbstCorrect(root.getRight(), root.getValue(), max);
        
        
    }
}
