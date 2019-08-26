package ok.demo;

import ok.demo.linkedlist.ll;

public class obtest {
  private static int i = 1;
  private static String s = "one";
  private static ll l = new ll(1, null);

  public static void main(String[] args) {

    System.out.println(i);
    update(i);
    System.out.println(i);

    System.out.println(s);
    update(s);
    System.out.println(s);
    update(s, "two");
    System.out.println(s);
    
    System.out.println(l.getValue());
    update(l);
    System.out.println(l.getValue());
    update(l, 2);
    System.out.println(l.getValue());
  }

  private static void update(int i) {
    i = 10;
  }

  private static void update(String i) {
    i = "two";
  }

  private static void update(String i, String j) {

    i = i.concat(j);
  }

  private static void update(ll l) {
    l = new ll(2, null);
  }

  private static void update(ll l, int j) {
    l.setValue(j);
  }
}
