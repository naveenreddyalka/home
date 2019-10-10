package ok.http;

import java.util.Scanner;
import java.util.stream.Stream;

public class a {
    static int c =0;
    static int getcount() {return c;}
    public a() {
        c++;
    }
    protected Number go() {
        System.out.println("b"); 
        return 1;
    }
    
     class c extends a{
         public c() {
             c++;
         }
         
    }
    
     public static void main(String[] args) {
         /*System.out.println(c );
         a x = new a();
         System.out.println(c );
         Stream.of("10",20).forEach(a -> System.out.print(a) );*/
         StringBuilder str = new StringBuilder();
         str.append("qw");
         str.append(10000);
         Scanner sc = new Scanner(str.toString());
         while(sc.hasNext()) {
             if(sc.hasNextInt()) {
                 System.out.println(sc.nextInt() + "--"); 
             }
             else sc.next();
         }
     }
}
