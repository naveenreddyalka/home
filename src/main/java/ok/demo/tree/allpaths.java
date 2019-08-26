package ok.demo.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class allpaths<T> {
  
  private static node found = null;
  private void get() {
   // T[] newa = Array.newInstance(T, 2);
  }

  public static void main(String[] args) {
    // -------7-------
    // ----3------11---
    // --1---5----9---13
    // -n-2-4-6-8-10-12-14
    int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    node root = buildminbst.getbstNice(test, 0, test.length - 1);

    

    //get(root,new ArrayList<Integer>());
    //System.out.println(print(root));
    //getByInt(root, new int[4], 0);
    System.out.println(lcm(root, 8, 11).getValue());
  }

  private static void print(node root,String path) {
    if(root==null) return;
    
    path = path+"-"+root.getValue();
    
    if(root.getLeft()== null && root.getRight()==null) {
      System.out.println(path);
      return;
    }
    if(root.getLeft()!=null)print(root.getLeft(), path);
    if(root.getRight()!=null)print(root.getRight(), path);
  }
  
  
  private static void get(node root,List<Integer> path) {
    if(root==null) return;
    
    path.add(root.getValue());
    
    if(root.getLeft()== null && root.getRight()==null) {
      path.forEach(s -> System.out.print("-"+s));
      System.out.println();
      path.remove(path.size()-1);
      return;
    }
    if(root.getLeft()!=null)get(root.getLeft(), path);
    if(root.getRight()!=null)get(root.getRight(), path);
    
    path.remove(path.size()-1);
  }
  
  private static void getByInt(node root,int[] path,int height) {
    if(root==null) return;
    
    path[height] = root.getValue();
    
    height++;
    if(root.getLeft()== null && root.getRight()==null) {
      System.out.println(Arrays.toString(path));
      return;
    }
    
    if(root.getLeft()!=null)getByInt(root.getLeft(), path,height);
    if(root.getRight()!=null)getByInt(root.getRight(), path,height);
  }
  
  private static node lcm(node root, int m,int n) {
    //if(found!=null) return found;
    
    if(root==null) return null;
    if(root.getValue()==m || root.getValue()==n) return root;
   
    node l = lcm(root.getLeft(),m,n);
    node r = lcm(root.getRight(),m,n);    
   
    if(l!=null && r!=null) {
      if((r.getValue()==n && l.getValue()==m)
          || (l.getValue()==n && r.getValue()==m)) {
       // found = root;
        return root;
      }
    } 
    
    if(r!=null) return r;
    else if(l!=null) return l;
    else return null;
  
  }
}
