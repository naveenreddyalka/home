package ok.test.dun;

import java.util.List;
import java.util.Queue;

public class Dun {

  public static void main(String[] args) {
    
  }
  
  /*public static void main(String[] args) {

    
//     1
//   2   3
//  4 5 6 7 


    Node r2 = new Node(6, null, null);
    Node r3 = new Node(7, null, null);

    Node l3 = new Node(5, null, null);
    Node l2 = new Node(4, null, null);
    
    Node r1 = new Node(3, r2, r3);
    Node l1 = new Node(2, l2, l3);
    
    Node root = new Node(1, l1, r1);
    
    int a = 4;
    int b = 6;
    
    System.out.println(distance(root, a, b));
    }
  
  public static int distance(Node root, int a, int b) {
    
    Node lca = getLCA(root, a, b);
    
    if(lca.getValue()!=a || lca.getValue()!=b) {
      
     return getPath(lca, a, 0) + getPath(lca, b, 0);
      
    }else if(lca.getValue()==a) {
      return getPath(lca, b, 0);
    }else {
      return getPath(lca, a, 0);
    }
    
  }
  
  public static int getPath(Node root, int a, int h) {
    if(root==null) {
      return -1;
    }
    
    if(root.getValue()==a) return h;
    
    int lp = getPath(root.getLeft(),a,h+1);
    int rp = getPath(root.getRight(),a, h+1);
    
    return  lp!=-1?lp:rp ;
  }
  
  public static Node getLCA(Node root, int a, int b) {
    
    if(root ==null) {
      return null;
    }
    
    if(root.getValue()==a || root.getValue()==b) {
      return root;
    }
    
    if((root.getValue() > a && root.getValue() < b) || 
        (root.getValue() > b && root.getValue() < a)) {
      return root;
    }else if(root.getValue() > a){
      return getLCA(root.getLeft(), a, b);
    }else {
      return getLCA(root.getRight(), a, b);
    }
    
    // a,a,a,a,b,d
    // LRU 3 - {a,b,c} ..{a,b,d}
    
    
    
    /*Node inLeft = getLCA(root.getLeft(), a, b);
    
    Node inRight = getLCA(root.getRight(), a, b);
    
    if(inLeft!=null && inRight!=null) return root;
    
    
    return inLeft==null?inRight:inLeft;
  }
   
  
  
  
    1

  /  \

  2   3

 /\    / \

4  5  6    7 


2,5r
3,6
3,7 
1,2
1,3




.
.



 1 2 

 
 
 
 
 1 3
 

      1 
     2 
      5    
   
   
     
      
        2 also a root --- 4 root
          
        2               
        
      3     4
         5     6 
         
         

    2-4 -> all nodes search(2,4)    
          
       
       
      2 root     4 root 
        
      
      2 node     n node
      
              server1 -       master  { root - not parent}
      server2 master2   server3-master3                             server2 master2   server3-master3
   
 server4 master2   server3-master3  
   
   
       5th master - searchAllNode( 12 ,10), searchAllNode( 11 ,12)
 
           1 
       2        3
 node1 node2 node3 node4
 4 11   
    12
     10
 
 
 4 node

line 0 , get 1024 bytes 


Size 40GB - 
each - 10GB -
4 node

  mainParser(File , ) {
      
    till log4  - level2 -- 1,2,3
    
    2-4,5  3-5,7
    
      distribute(4, line6)
      distribute(5, line7)
      distribute(6, line8)
      distribute(7, line9)
      
    }
  
      


 level1= {1}, level2 = {2,3}, level3= {4,5,6,7}
 
    
    
    
    qu [,,,,,4,5,6,7,null]
        root = 1
        count =2
        n= null
    result {1}  {2,3}  
  List<List<Node>> getLevel(Node root){
      
      List<List<Node>> result = new ArrayList<Node>();
      
      Queue<Node> qu = new Queue<Node>();
      int count = 0;
      
      if(root==null) result;
      
      qu.add(root);
      qu.add(null);
      
      while(!qu.isEmpty()) {
        
        Node n =  qu.poll();
        
        if(n==null) {
          if(qu.isEmpty()) return result;
          qu.add(null);
          count++;
          continue;
        }      
  
        if(result.get(count)==null) {
          List<Node> add = new  ArrayList<Node>();
          result.set(count,add);
        }
        
        result.get(count).add(n);
        
        if(n.getLeft()!=null) {
          qu.add(n.getLeft());
        }
        
        if(n.getRight()!=null) {
          qu.add(n.getRight());
        }
         
      }
      
      return result;
    }
  
  
  */
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
