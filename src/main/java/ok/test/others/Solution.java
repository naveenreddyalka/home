package ok.test.others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.codec.CharEncoding;
import org.junit.runner.notification.RunListener;

public class Solution {

    
    
    static {
        System.out.println("---"); 
    }
    int a = 10;
    
    {
        System.out.println("++++"); 
    }
  public static void main(String[] args) throws Exception{
      
      /*Supplier<String> i = () -> "Car";
      Consumer<String> c = x -> System.out.print(x.toLowerCase() );
      Consumer<String> d = x -> System.out.print(x.toUpperCase() );
      c.andThen(d).accept(i.get());
      System.out.println();*/
      
      /*String f = "f";
      String s = new String("f");
      "f".concat("s");
      System.out.println(f.equals(s));
      System.out.println(f ==(s));
      System.out.println(f.equals("fs") );
      System.out.println(s =="f");
      Solution s = new Solution();
      YearMonth y1 = YearMonth.now();
      YearMonth y2 = YearMonth.of(2018, Month.FEBRUARY); 
      
       System.out.println(y1.compareTo(y2));**
      
      String a = null;
      Optional<String> b = Optional.ofNullable("");
      System.out.println(b.get().length()); */
     
      Solution a = new Solution();
  }
  
  
  static ArrayList<Integer> cyclicQueue(String[] commands) {

      final int maxSize = 10;
      int[] myQueue = new int[maxSize];
      ArrayList<Integer> answer = new ArrayList<>();
     // answer.stream().limit(maxSize)map(j->j).max((s,d)-> 1);
      int head = 0;
      int tail = 0;
      int sum = 0;

      for (int i = 0; i < commands.length; i++) {
        if (commands[i].equals("-")) {
          sum -= myQueue[head];
          head = (head+1)% maxSize;
          
        }
        else {
          int value = 0;
          for (int j = 1; j < commands[i].length(); j++) {
            value = value * 10 + (int)commands[i].charAt(j) - (int)'0';
          }
          sum += value;
          myQueue[tail] = value;
          tail = (tail + 1) % maxSize;
        }
        answer.add(sum);
      }

      return answer;
    }
  
  

  public  List<List<Integer>> optimalUtilization(int maxTravelDist,
      List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (maxTravelDist <= 0 || forwardRouteList == null || returnRouteList == null
        || forwardRouteList.size()==0 || returnRouteList.size()==0) {
      return result;
    }

    int optimal = -1;

    Map<Integer, List<List<Integer>>> allRoutes = new HashMap<Integer, List<List<Integer>>>();

    for (List<Integer> fw : forwardRouteList) {
      for (List<Integer> re : returnRouteList) {
        if (fw.get(1) + re.get(1) <= maxTravelDist && fw.get(1) + re.get(1) >= optimal) {
          optimal = fw.get(1) + re.get(1);

          List<Integer> toAdd = new ArrayList<>();
          toAdd.add(fw.get(0));
          toAdd.add(re.get(0));

          if (allRoutes.get(optimal) != null) {
            allRoutes.get(optimal).add(toAdd);
          } else {
            List<List<Integer>> newList = new ArrayList<List<Integer>>();
            newList.add(toAdd);
            allRoutes.put(optimal, newList);
          }

        }

      }
    }

    if (optimal > 0) {
      result = allRoutes.get(optimal);
    }

    return result;

  }
}
