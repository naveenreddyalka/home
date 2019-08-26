package ok.demo.tree;

public class maxpathsum {

    static int  i = 0;
    public static void main(String[] args) {
        // -------7-------
        // ----3------11---
        // --1---5----9---13
        // -n-2-4-6-8-10-12-14
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        node root = buildminbst.getbstNice(test, 0, test.length - 1);
        System.out.println("888"); 
        
        update();
        
        System.out.println(i); 
    }
    
    public static int getMax(node root,int max) {
        if(root==null) return 0;
        
        int l=0;
        int r=0;
        
        if(root.getLeft()!=null){
            l = getMax(root.getLeft());
        }
        
        if(root.getRight()!=null){
            r = getMax(root.getRight());
        }
        
        int oneSide = Math.max(l+root.val, r+root.val);
        if(oneSide>root.val) {
            if(max<oneSide) {
                max=oneSide;
            }
            if(max<l+root.val+r) {
                max=l+root.val+r;
            }
        }else if(max<root.val){
            max=root.val
        }
        
        if(max < l+r+root.getValue()) {
            max =  l+r+root.getValue();
        }
        
        return Math.max(r, l)+root.val;}
    
    public static void update() {
        i =1;
    }
}
