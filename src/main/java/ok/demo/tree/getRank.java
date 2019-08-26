package ok.demo.tree;

public class getRank {
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14};
        node root = buildminbst.getbstNice(test, 0, test.length-1);
        System.out.println(getRankofX(root, 4));
    }
    private static int getRankofX(node root,int x) {
        if(root.getValue()==x) {
            return getsize.get(root);
        }else if(root.getValue()>x) {
            return root.getLeft()==null? -1:getRankofX(root.getLeft(), x);
        }else {
            int rank = root.getRight()==null?-1:getRankofX(root.getRight(), x);
            if(rank!=-1) {
                rank = rank + 1 + getsize.get(root.getLeft());
            }
            return rank;
        }
    }
}
