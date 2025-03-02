package ok.metaprep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {

  public static void main(String[] args) {
    SnapshotArray sa = new SnapshotArray(4);
    sa.snap();
    sa.snap();
    sa.get(3,1);
    sa.set(2,4);
    sa.snap();
    sa.set(1,4);


    SnapshotArray sa2 = new SnapshotArray(3);
    sa2.set(0,5);
    sa2.snap();
    sa2.set(0,6);
    System.out.println(sa2.get(0,0));


  }


  int length;
  int curr;
  boolean changedFromLastSnap;
  Map<Integer,int[]> store = new HashMap<>();
  Map<Integer,Integer> snapMap = new HashMap<>();

  public SnapshotArray(int length) {
    this.length = length;
    this.curr=0;
    this.store = new HashMap<>();
    this.changedFromLastSnap = false;
    this.store.put(0,new int[length]);
  }

  public void set(int index, int val) {
    store.computeIfAbsent(curr,c -> Arrays.copyOf(store.get(snapMap.get(curr - 1)), length))[index] = val;
    changedFromLastSnap=true;
  }

  public int snap() {
    if(curr==0){
      snapMap.put(0,0);
      changedFromLastSnap=false;
      curr++;
    }else{
      if(changedFromLastSnap) {
        snapMap.put(this.curr,this.curr);
        changedFromLastSnap=false;
        curr++;
      }else{
        snapMap.put(this.curr,snapMap.get(this.curr-1));
        curr++;
      }
    }
    return curr-1;
  }

  public int get(int index, int snap_id) {
    return store.get(snapMap.get(snap_id))[index];
  }
}
