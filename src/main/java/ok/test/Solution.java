package ok.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {

  }

  private static List<List<Integer>> optimalUtilization(int maxTravelDist,
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
