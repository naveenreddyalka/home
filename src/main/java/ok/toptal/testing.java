package ok.toptal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testing {

    private int id;
  
  @Override
  public int hashCode() {
    return id;
  }
  
  @Override
  public boolean equals(Object obj) {
      if(obj instanceof testing) {
          return this.id==((testing)obj).id;
      }
    return false;
  }
  
  public static void main(String[] args) {
      
      
  }
  
  

  private List<testing> removeDups(List<testing> in) {

    Map<testing, Integer> dups = new HashMap<testing, Integer>();

    for (testing i : in) {
      if (dups.get(i) == null) dups.put(i, 1);

      dups.put(i, dups.get(i) + 1);
    }

    List<testing> ret = new ArrayList<testing>();

    for (testing i : dups.keySet()) {
      ret.add(i);
    }
    return ret;
  }
}
