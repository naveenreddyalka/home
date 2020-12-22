package ok.test.dun;

public class Node {

  private int value;
  private Node left;
  private Node right;
  
  public int getValue() {
    return value;
  }
  public void setValue(int value) {
    this.value = value;
  }
  public Node getLeft() {
    return left;
  }
  public void setLeft(Node left) {
    this.left = left;
  }
  public Node getRight() {
    return right;
  }
  public void setRight(Node right) {
    this.right = right;
  }
  public Node(int value, Node left, Node right) {
    super();
    this.value = value;
    this.left = left;
    this.right = right;
  }
  
}
