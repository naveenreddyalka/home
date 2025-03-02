package ok.toptal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class Toptal3 {


    public static void main(String[] argv) {
        String expression1 = "6+9-12"; // = 3
        String expression2 = "1+2-3+4-5+6-7"; // = -2
        String expression3 = "100+200+300"; // = 600
        String expression4 = "1-2-3-0"; // = -4
        String expression5 = "255"; // = 25

        System.out.println(getValue("6+9-12"));
      }

      public static int getValue(String ex){
        int sum =0;
        Character lastOp = null;

        if(ex==null || ex.length()==0 || getOp(ex.charAt(0))){ return -1;}
        String pre = null;
        String cur = "";
       for(int i=0;i<ex.length();i++){

          char  c  = ex.charAt(i);
          if(getOp(c)){
              pre = cur;
              if(lastOp==null) {
                  sum = sum + Integer.parseInt(pre);
              }else {
                  sum = getSum(lastOp, sum, Integer.parseInt(pre));
              }
              lastOp = c;
              cur="";
            }else{

                cur= cur+c;
          }

        }
       return getSum(lastOp, sum, Integer.parseInt(cur));

      }


      public static  int getSum(Character c, int sum, int val) {
          if(c==null) return val;
          if(c=='-') {
              return sum - val;
          } else {
              return sum + val;
          }

      }



        public static  boolean getOp(char c) {
          if(c=='-') return true;
          if(c=='+') return true;
          return false;
      }





  public int test1(int a, int b) {
    int carryCount = 0;
    int carry = 0;
    while (a > 10 || b > 10) {
      // a = 123
      int ac = a % 10;

      // b=87
      int bc = b % 10;

      if (ac + bc + carry >= 10) {
        carry = 1;
        carryCount++;
      } else {
        carry = 0;
      }

      a = a / 10;
      b = b / 10;
    }

    if (a + b + carry >= 10) {
      carryCount++;
    }

    return carryCount;
  }

 // public static void main(String[] args) {

    /*int arr[] = {1, 9, 87};

    int arr2[][] = new int[4][4];
    arr2[0] = new int[] {1, 2, 3, 4};

    int arr3[][] = {
      {1, 2, 3, 4},
      {3, 4, 3, 4}
    };

    Arrays.sort(arr);

    List<Integer> intl = Arrays.stream(arr).boxed().collect(Collectors.toList());

    Collections.sort(intl);

    System.out.println(Arrays.toString(arr));

    String numbers = "1 2 3 4";
    List<Integer> x =
        Arrays.stream(numbers.split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

    char[] charAar = numbers.toCharArray();
    Set<Character> charset = numbers.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

    try (Scanner input = new Scanner(System.in).useDelimiter("\n")) {
      while (input.hasNextLine()) {
        System.out.println("-->" + input.next());
        input.close();
        break;
      }*/
 // }
}
