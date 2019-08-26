package ok.demo.linkedlist;

public class kthtothelastll {

    private static ll kth = null;
    
    public static void main(String[] args) {
        ll one = new ll(1, new ll(2, new ll(3, new ll(3, new ll(5, new ll(6, null))))));
        
        getKth(one, 5);
        System.out.println(kth.getValue());
        System.out.println(getKthElement(one, 5).getValue());
        ll dele = deleteMiddle(one);
        System.out.println(dele);
        
    }
    
    private static int getKth(ll root,int k) {
       
        if(root==null) return 0;
        int index = getKth(root.getNext(),k) + 1;
        if(index==k) kth = root;
        return index;
    }
    
    private static ll getKthElement(ll root,int k) {
        ll pointer1 =  root;
        while(root!=null && k>0) {
            root = root.getNext();
            k--;
        }
        
        if(root==null) return null;
        ll pointer2 = root;
        
        while(pointer2!=null) {
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }
        
        return pointer1;
    }
    
    private static ll deleteMiddle(ll root) {
        if(root==null) return null;
        ll p1 = root;
        ll p2 = root;
        ll previous = root;
       /* while (p2!=null && p1!=null) {
            previous = p1;
            p1 = p1.getNext();
            p2 = p2.getNext();
            if(p2!=null) p2 = p2.getNext();
        }*/ 
        
        while (p2!=null && p2.getNext()!=null) {
            previous = p1;
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
        }
        
        previous.setNext(p1.getNext());
        return root;
    }
}
