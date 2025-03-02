package ok.metaprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValue {

  public static void main(String[] args) {
    TimeMap tm = new TimeMap();

    tm.set("foo","bar",1);
    tm.set("love","low",20);
    tm.set("foo","bar2",4);
    System.out.println( tm.get("foo",4));
    System.out.println( tm.get("foo",5));
  }

}

class TimeMap {
  class Data{
    String value;
    int timestamp;
    public Data(String value, int timestamp){
      this.value = value;
      this.timestamp = timestamp;
    }
  }

  Map<String, List<Data>> store ;

  public TimeMap() {
    store = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<Data> val = store.getOrDefault(key,new ArrayList<>());
    val.add(new Data(value, timestamp));
    store.put(key,val);
  }

  public String get(String key, int timestamp) {
    if(store.containsKey(key)){
      List<Data> val = store.get(key);

      if(timestamp > val.get(val.size()-1).timestamp){ return val.get(val.size()-1).value;}

      if(timestamp < val.get(0).timestamp){ return "";}

      int l=0, r = val.size()-1;
      String result = "";
      while(l<=r){
        int m = l + (r-l)/2;
        if(val.get(m).timestamp > timestamp){
         r = m-1;
        } else if (val.get(m).timestamp < timestamp) {
          result = val.get(m).value;
         l=m+1;
        }else{
          return val.get(m).value;
        }
      }

      return result;
    }
    return "";
  }
}
