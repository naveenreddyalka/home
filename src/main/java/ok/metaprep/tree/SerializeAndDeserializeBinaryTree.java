package ok.metaprep.tree;

import java.util.ArrayList;
import java.util.List;

class SADBTreeNode<T> {
     T data;
     SADBTreeNode<T> left;
     SADBTreeNode<T> right;

     SADBTreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

public class SerializeAndDeserializeBinaryTree {


  public static String recursiveFunction(String str, List<String> strings){
    if (str.isEmpty()) return str;
    strings.add(str);// C
    str = str.substring(1);
    recursiveFunction(str,strings); // Passes the new string
    System.out.println(str);
    return str;
  }

  public static void immutabilityTest(String str, List<String> strings, Integer i,SADBTreeNode<Integer> node ){
    str = str+str;
    i = i+i;
    strings.addAll(strings);
    node = new SADBTreeNode<>(node.data+node.data);
  }

  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    String valu = recursiveFunction("hello",strings);
    System.out.println(valu);
    String h = "hello";
    Integer i = 1;
    int ten=10;
    SADBTreeNode<Integer> t = new SADBTreeNode<>(ten);
    immutabilityTest(h,strings,ten,t);
    int[] currPath = new int[10];

    System.out.println(strings);
    System.out.println(h);
    System.out.println(ten);
    System.out.println(t.data);
    SADBTreeNode<Integer> t100 = new SADBTreeNode<>(100);
    SADBTreeNode<Integer> t50 = new SADBTreeNode<>(50);
    SADBTreeNode<Integer> t200 = new SADBTreeNode<>(200);
    SADBTreeNode<Integer> t25 = new SADBTreeNode<>(25);
    SADBTreeNode<Integer> t75 = new SADBTreeNode<>(75);
    SADBTreeNode<Integer> t350 = new SADBTreeNode<>(350);
    t100.left = t50;
    t100.right = t200;
    t50.left = t25;
    t50.right = t75;
    t200.left = t350;

    List<String> serialized = serialize(t100);
    System.out.println(serializeHelper2(t100));
    List<String> one = new ArrayList<>();
    serializeHelper(t100,one);
    System.out.println(one);

    SADBTreeNode<Integer> deserialized = deserialize(serialized);
    printTree(deserialized);
  }

  public static void printTree(SADBTreeNode<Integer> root) {
    if (root == null) {
      return;
    }
    printTree(root.left);
    System.out.print(root.data + " ");
    printTree(root.right);
  }

  public static void serializeHelper(SADBTreeNode<Integer> root,List<String> result) {
    if(root==null) {
      result.add(null);
      return;
    }
    result.add(root.data.toString());
    serializeHelper(root.left,result);
    serializeHelper(root.right,result);
  }

  public static List<String> serializeHelper2(SADBTreeNode<Integer> root) {
    List<String> result = new ArrayList<>();
    if(root==null) {
      result.add(null);
      return result;
    }
    result.add(root.data.toString());
    result.addAll(serializeHelper2(root.left));
    result.addAll(serializeHelper2(root.right));
    return  result;
  }

  public static List<String> serialize(SADBTreeNode<Integer> root) {
    return serializeHelper2(root);
  }

  public static SADBTreeNode<Integer> deserializeHelper(List<String> stream) {
      if(stream.isEmpty()) return null;
      String val = stream.remove(0);
      if(val == null) return null;
      SADBTreeNode<Integer> root = new SADBTreeNode<>(Integer.parseInt(val));
      root.left = deserializeHelper(stream);
      root.right = deserializeHelper(stream);
      return root;
  }

  public static SADBTreeNode<Integer> deserialize(List<String> stream) {
    return deserializeHelper(stream);
  }
}
