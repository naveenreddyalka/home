package ok.demo.linkedlist;

public class ll {

    private ll next;
    private int value;
    
    public ll getNext() {
        return next;
    }
    public void setNext(ll next) {
        this.next = next;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public ll(int value,ll next) {
      super();
      this.next = next;
      this.value = value;
    }
    
}
