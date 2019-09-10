package ok.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sol extends Solution {
  int a = 120;

  public List<List<Integer>> optimalUtilization(
      int maxTravelDist,
      List<List<Integer>> forwardRouteList,
      List<List<Integer>> returnRouteList) {
    return null;
  }

  public static void test(List<String> inputByLine) {
    
      String one = "";
      String two = "";
      
      for (String line2 : inputByLine) {
          String[] ls = line2.split(" ");
          one = ls[0];
          two = ls[1];
      }
         
     int min =0;
    
     String oneMin = one.replace("5", "6");
     String twoMin = one.replace("5", "6");
     
     min = Integer.parseInt(oneMin) + Integer.parseInt(twoMin);
     
    
    
    
    inputByLine.set(0, String.valueOf(min));
    inputByLine.set(1, String.valueOf(max));
    
    for (String line2 : inputByLine) System.out.println(line2);
  }

  public static void main(String[] args) {
    List<String> inputByLine = new ArrayList<String>();
    inputByLine.add("11");
    inputByLine.add("35");
    sol.test(inputByLine);
  }
}
