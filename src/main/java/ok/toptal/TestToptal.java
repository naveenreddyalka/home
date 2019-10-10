package ok.toptal;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestToptal {
    
    
    
    
  /* Toptal3 toptal3 = new Toptal3();

    @Test
    public void case1() {
      assertEquals(toptal3.test1(123, 456),0);
      assertEquals(toptal3.test1(555, 555),3);
      assertEquals(toptal3.test1(900, 1),0);
      assertEquals(toptal3.test1(145, 55),2);
      assertEquals(toptal3.test1(0, 0),0);
      assertEquals(toptal3.test1(1, 99999),5);
      assertEquals(toptal3.test1(999045, 1055),5);
    }
  */

  public static int numDecodings(String s) {
    if (s == null || s.isEmpty()) return 0;

    int sum = 0;

    if (Integer.parseInt(s) == 0 || s.startsWith("0") || s.contains("00")) return 0;
    
    if (s.length() == 1) {
      return 1;
    }

    int i = 0;
    int pre = 9;
    while (i < s.length()) {
      if (Integer.parseInt(pre + "" + s.charAt(i)) >9 &&
              Integer.parseInt(pre + "" + s.charAt(i)) < 27
              &&
              Integer.parseInt(pre + "" + s.charAt(i)) != 10
              && Integer.parseInt(pre + "" + s.charAt(i)) != 20) {
          if(!(i<s.length()-1 && s.charAt(i+1)=='0')) {
              sum = sum + 1;
          }
        
      }
      pre = Integer.parseInt("" + s.charAt(i));
      i++;
    }
    return sum + 1;
  }

  public static int getStr(String a, String b) {

    Map<Integer, String> maps = new HashMap<Integer, String>();
    for (int i = 0; i < 11; i++) {
      maps.put(i, "" + i);
    }

    maps.forEach(
        (key, value) -> {
          System.out.println("Key : " + key + " Value : " + value);
        });

    if (a == null || b == null || a.isEmpty() || b.isEmpty()) throw new RuntimeException();

    String res = "";
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (true) {
      int a1 = Integer.parseInt(Character.toString(a.charAt(i)));
      int b2 = Integer.parseInt(Character.toString(b.charAt(j)));
      int c = a1 + b2 + carry;
      if (c > 9) {
        carry = 1;
        c = c - 10;
      } else carry = 0;
      res = res + "" + c;
      i--;
      j--;
      if (i < 0) {
        res = res + "" + carry;
        break;
      }
    }
    String ret = "";

    for (int k = res.length() - 1; k >= 0; k--) {
      ret = ret + res.charAt(k);
    }

    return Integer.parseInt(ret);
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("110"));
    // System.out.println(getStr("12", "23"));

  }
  
  
  
}
