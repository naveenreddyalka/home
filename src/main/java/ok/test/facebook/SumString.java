package ok.test.facebook;

public class SumString {

  public static void main(String[] args) {
    SumString s = new SumString();
    System.out.println(s.addStrings("6","501"));
  }

  public String addStrings(String num1, String num2) {
    String out = "";
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;

    while (i >= 0 && j >= 0) {

      int sum = Integer.parseInt(String.valueOf(num1.charAt(i)))
          + Integer.parseInt(String.valueOf(num2.charAt(j))) + carry;

      if (sum >= 10) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }

      out = sum + "" + out;
      i--;
      j--;
    }

    while (i >= 0) {
      int sum = Integer.parseInt(String.valueOf(num1.charAt(i))) + carry;

      if (sum >= 10) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }

      out = sum + out;
      i--;
    }

    while (j >= 0) {
      int sum = Integer.parseInt(String.valueOf(num2.charAt(j))) + carry;

      if (sum >= 10) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }

      out = sum + out;
      j--;
    }

    if (carry != 0) {
      out = carry + out;
    }

    return out;
  }
  
  
  public String addBinary(String a, String b) {
    String out = "";
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    while (i >= 0 && j >= 0) {

      int sum = Integer.parseInt(String.valueOf(a.charAt(i)))
          + Integer.parseInt(String.valueOf(b.charAt(j))) + carry;

      if (sum >= 2) {
        carry = 1;
        sum = sum % 2;
      } else {
        carry = 0;
      }

      out = sum + "" + out;
      i--;
      j--;
    }

    while (i >= 0) {
      int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + carry;

      if (sum >= 2) {
        carry = 1;
        sum = sum % 2;
      } else {
        carry = 0;
      }

      out = sum + out;
      i--;
    }

    while (j >= 0) {
      int sum = Integer.parseInt(String.valueOf(b.charAt(j))) + carry;

      if (sum >= 2) {
        carry = 1;
        sum = sum % 2;
      } else {
        carry = 0;
      }

      out = sum + out;
      j--;
    }

    if (carry != 0) {
      out = carry + out;
    }

    return out;
  }
}
