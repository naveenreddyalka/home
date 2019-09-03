package ok;

import java.util.Scanner;

public class test {

  public static void main(String[] args) {
    String number = "123456789";

    System.out.println(number.substring(number.length() - 7));
  }

  public static void main2(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    out("Enter");
    while (input.hasNextLine()) {}

    input.close();
  }

  private static void out(String str) {
    System.out.println(str);
  }
}
