package ok.demo.tree;

public class buildminbst {

    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14};
        node root = getbstNice(test, 0, test.length-1);
        System.out.println(root.getValue());
    }

    private static node getbst(int[] arr, int start, int end) {
        node root = new node();
       
        if (end - start == 1) {
            root.setValue(arr[end-1]);
            return root;
        } 
        if (end - start == 2) {
            root.setValue(arr[end-1]);
            node left = new node();
            left.setValue(arr[end-2]);
            root.setLeft(left);
            return root;
        }

        root.setValue(arr[start+(end-start)/ 2]);

        if (end - start == 3) {
            node left = new node();
            left.setValue(arr[start]);
            node right = new node();
            right.setValue(arr[end - 1]);
            root.setLeft(left);
            root.setRight(right);
            return root;
        }
        root.setLeft(getbst(arr, start, (start+ (end-start) / 2)));
        root.setRight(getbst(arr, (start + (end-start) / 2)+1, end));

        return root;
    }
    
    public static node getbstNice(int[] arr, int start, int end) {
        if(end<start) {
            return null;
        }
        node root = new node(); root.setValue(arr[(end+start)/2]);
        root.setLeft(getbstNice(arr, start, ((end+start)/2)-1));
        root.setRight(getbstNice(arr,((end+start)/2)+1,end));
        return root;
    }
}
