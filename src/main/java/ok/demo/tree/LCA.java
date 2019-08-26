package ok.demo.tree;

public class LCA {
    public static void main(String[] args) {
        // -------7-------
        // ----3------11---
        // --1---5----9---13
        // -n-2-4-6-8-10-12-14
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        node root = buildminbst.getbstNice(test, 0, test.length - 1);
        node right = root;
        node left = root.getRight().getRight().getLeft();
        node lcs = getLca(root, left, right);
        System.out.println(lcs.getValue());
    }
    
    public static node getLca(node root, node one, node two) {
        if(root ==null) return null;
        if(root ==one && root == two) return root;
        
        node rx = getLca(root.getLeft(), one, two);
        if(rx!=null && rx!=one && rx!=two ) return rx;
        
        node ry = getLca(root.getRight(), one, two);
        if(ry!=null && ry!=one && ry!=two) return ry;
        
        if(rx!=null && ry!=null) {
            return root;
        }else if(root==one || root == two){
            return root;
        }else {
            return rx==null?ry:rx;
        }
                   
    }
    
    public static result getLcaCorrect(node root, node one, node two) {
        if(root ==null) {return new result(null, false);}
        if(root ==one && root == two) return new result(root, true);
        
        result rx = getLcaCorrect(root.getLeft(), one, two);
        if(rx.isLca) return rx;
        
        result ry = getLcaCorrect(root.getLeft(), one, two);
        if(ry.isLca) return ry;
        
        if(rx.root!=null && ry.root !=null) {
            return new result(root, true);
        }else if(root ==one || root == two){
            boolean isLca = rx.root!=null || ry.root!=null;
            return new result(root, isLca);
        }else {
            return new result(rx.root==null?ry.root:rx.root, false);
        }
        
    }
    
    

}
