package ok.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonPackageDistribute {

  public static void main(String[] args) {
    ArrayList<Integer> intp = new ArrayList<Integer>();
    intp.add(100);
    intp.add(180);
    intp.add(40);
    intp.add(120);
    intp.add(10);

    intp = IDsOfPackages(250, intp);

    System.out.println(intp);
  }

  private static ArrayList<Integer> IDsOfPackages(int truckSpace,
      ArrayList<Integer> packagesSpace) {

    List<List<Integer>> results = new ArrayList<List<Integer>>();
    ArrayList<Integer> output = new ArrayList<Integer>();
    
    if (truckSpace <= 30) {
      return output;
    }

    if (packagesSpace.size() < 2) {
      return output;
    }

    int packSize = truckSpace - 30;

    // key - size, value - indexes
    Map<Integer, List<Integer>> packMap = new HashMap<Integer, List<Integer>>();

    for (int i = 0; i < packagesSpace.size(); i++) {
      if (packMap.get(packagesSpace.get(i)) != null) {
        packMap.get(packagesSpace.get(i)).add(i);
      } else {
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(i);
        packMap.put(packagesSpace.get(i), newList);
      }
    }

   // search for the complement and add 
    for (int i = 0; i < packagesSpace.size(); i++) {

      if (packMap.get(packSize - packagesSpace.get(i)) != null) {
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(i);
        
        newList.add(packMap.get(packSize - packagesSpace.get(i)).get(0));
        
        results.add(newList);
      }

    }


// find the max package size if more than 1 result
    
    if (results.size() == 1) {
      output.addAll(results.get(0));
    } else if (results.size() > 0) {
      output.addAll(results.get(0));
      int max = packagesSpace.get(output.get(0)) > packagesSpace.get(output.get(1))
          ? packagesSpace.get(output.get(0))
          : packagesSpace.get(output.get(1));

      for (List<Integer> values : results) {
        if (values.get(0) != values.get(1)
            && (packagesSpace.get(values.get(1)) > max || packagesSpace.get(values.get(0)) > max)) {
          output = new ArrayList<Integer>();

          if (values.get(0) < values.get(1)) {
            output.add(values.get(0));
            output.add(values.get(1));
          } else {
            output.add(values.get(1));
            output.add(values.get(0));
          }

        }
      }
    } 
    return output;

  }
  
  public int smallestRangeII(int[] A, int K) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] > max)
        max = A[i];
      if (A[i] < min)
        min = A[i];
    }

    for (int i = 0; i < A.length; i++) {
      if (A[i] >= (max + min) / 2)
        A[i] = A[i] - K;
      else
        A[i] = A[i] + K;
    }

    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] > max)
        max = A[i];
      if (A[i] < min)
        min = A[i];
    }

    return (max - min);

  }

}
