package ok.metaprep.print;

import java.util.HashMap;
import java.util.Map;

class DLLNode{
  int key;
  int value;
  DLLNode next;
  DLLNode pre;
  DLLNode(int value, int key) {
    this.value = value;
    this.key = key;
  }
}

public class LRUCache {
  DLLNode head;
  DLLNode tail;
  int size;
  int curr;
  Map<Integer, DLLNode> map;

  public LRUCache(int size) {
    this.size = size;
    map = new HashMap<>();
    head = new DLLNode(-1,-1);
    tail = new DLLNode(-2,-2);
    head.next =tail;
    this.curr = 0;
  }

  int get(int key) {
    if(!map.containsKey(key))
      return -1;
    DLLNode node = map.get(key);
    moveToFront(node);
    return node.value;
  }

  void set(int key, int value) {

    if(map.containsKey(key)){
      map.get(key).value = value;
      moveToFront(map.get(key));
    }else{

      if(curr>=size){
        map.remove(remove(tail.pre).key);
        curr--;
      }
      curr++;

      DLLNode node = new DLLNode(value,key);
      moveToFront(node);
      map.put(key,node);
    }
  }

  public void moveToFront(DLLNode first){
    if(head.next==first) return;
    first = remove(first);

    DLLNode tail = head.next;

    first.pre = head;
    first.next = tail;

    head.next = first;

    tail.pre = first;
  }

  public DLLNode remove(DLLNode remove){
    DLLNode tail = remove.next;
    DLLNode head = remove.pre;
    if(tail==null || head==null) return remove;
    head.next = tail;
    tail.pre = head;
    return remove;
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.set(10, 100);
    cache.get(10);
    cache.set(15, 50);
    cache.get(10);
    cache.set(30, 300);
    cache.get(15);
    cache.get(30);
  }
}
