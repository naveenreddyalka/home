package ok.test.others;

import java.util.Scanner;

public class test {

  static int b = getValue();
  static int a = 10;

  static int getValue() {
    return a;
  }
  
  static int doSum() { return a+b;}
  static int doM() { return a-b;}
  public static void main(String[] args) {
	  
	  for(char i ='a';i<= 'z';i++ ) {
		//  Character.toChars(codePoint)
	    	System.out.print(i);
	    } System.out.println("");
	  
	  
    System.out.println(doSum());
    System.out.println(doM());
      //String number = "123456789";

    //System.out.println(number.substring(number.length() - 7));
  }

  public static void main2(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	  
	 

	  
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    out("Enter");
    while (input.hasNextLine()) {}
    
    
    for(char i ='a';i< 'z';i++ ) {
    	System.out.println(i);
    }

    input.close();
  }

  private static void out(String str) {
	  
    System.out.println(str);
  }
}
