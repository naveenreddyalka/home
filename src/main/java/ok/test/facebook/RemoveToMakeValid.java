package ok.test.facebook;

import java.util.Stack;

public class RemoveToMakeValid {

  public static void main(String[] args) {

    System.out.println(minRemoveToMakeValid(")))t((u)"));
    // System.out.println(minRemoveToMakeValid("(dsa)((dsa)))"));

    // System.out.println("".equalsIgnoreCase(minRemoveToMakeValid("))((")));
    // System.out.println("a(b(c)d)".equalsIgnoreCase(minRemoveToMakeValid("(a(b(c)d)")));
    // System.out.println("ab(c)d".equalsIgnoreCase(minRemoveToMakeValid("a)b(c)d")));
    // System.out.println("lee(t(c)o)de".equalsIgnoreCase(minRemoveToMakeValid("lee(t(c)o)de)")));
  }

  public static String minRemoveToMakeValid(String s) {
    Stack<Value> check = new Stack<Value>();
    Boolean[] ift = new Boolean[s.length()];
  
    if (s == null || s.isEmpty())
      return s;

    for (int i = 0; i < s.length(); i++) {
     
      String l = String.valueOf(s.charAt(i));

      if (l.equals(")")) {
        while (!check.isEmpty() && !check.peek().getL().equals("(") && !check.peek().getL().equals(")")) {
          Value v = check.pop();
          ift[v.getI()]=true;
        }
        
        if (!check.isEmpty() && check.peek().getL().equals("(")) {
          Value v = check.pop();
          ift[v.getI()]=true; ift[i]=true; 
        }
        while (!check.isEmpty() && !check.peek().getL().equals("(") && !check.peek().getL().equals(")")) {
          Value v = check.pop();
          ift[v.getI()]=true;
        }

      } else {
        check.add(new Value(i, l));
      }

    }
    
    String out = "";
    
    while (!check.isEmpty()) {
      if(!check.peek().getL().equals("(") && !check.peek().getL().equals(")")) {
        Value v = check.pop();
        ift[v.getI()]=true;
      }else {
        check.pop();
      }
    }
    
    for(int i=0;i<ift.length;i++) {
      if(ift[i]!=null && ift[i]) out = out + s.charAt(i);
    }

    return out;
  }
  

  

}

class Value {
  int i;
  String l;
  public int getI() {
    return i;
  }
  public void setI(int i) {
    this.i = i;
  }
  public String getL() {
    return l;
  }
  public void setL(String l) {
    this.l = l;
  }
  public Value(int i, String l) {
    super();
    this.i = i;
    this.l = l;
  }
  
}


