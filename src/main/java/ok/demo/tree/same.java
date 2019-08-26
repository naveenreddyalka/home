package ok.demo.tree;

public class same {

  public static void main(String[] args) {
    
  }
  
  private static boolean sameCheck(node a,node b) {
    if(a==null && b==null) return true;
    if(a==null && b!=null) return false;
    if(a!=null && b==null) return false;
    if(a.getValue()!=b.getValue()) return false;
    
    return sameCheck(a.getLeft(), b.getLeft()) && sameCheck(a.getRight(), b.getRight());
    
  }
}
