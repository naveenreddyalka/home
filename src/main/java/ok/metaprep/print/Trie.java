package ok.metaprep.print;

import java.util.ArrayList;
import java.util.List;

class Node{
  Character c;
  Boolean isEnd = false;
  List<Node> next;
  Node( Character c){
    this.c = c;
    this.next = new ArrayList<>();
    for(int i=0;i<26;i++){
      this.next.add(null);
    }
  }
}

public class Trie {

  public static void main(String[] args) {
    Trie t = new Trie();
    t.insert("abc");
    System.out.println(t.search("abc"));
  }


  Node root;

  public Trie() {
    this.root = new Node(null);
  }

  public void insert(String word) {
    if(word==null) return;
    Node curr = root;
    for(int i=0; i < word.length();i++){
      if(curr.next.get((int) word.charAt(i)-'a')==null){
        Node n = new Node(word.charAt(i));
        curr.next.set((int) word.charAt(i)-'a', n);
      }
      curr = curr.next.get((int) word.charAt(i)-'a');
    }
    curr.isEnd = true;
  }

  public boolean search(String word) {
    if(word==null) return false;
    Node curr = root;
    for(int i=0; i < word.length();i++){
      if(curr.next.get((int) word.charAt(i)-'a')==null){
        return false;
      }
      curr = curr.next.get((int) word.charAt(i)-'a');
    }
    return curr.isEnd;
  }

  public boolean startsWith(String prefix) {
    if(prefix==null) return false;
    Node curr = root;
    for(int i=0; i < prefix.length();i++){
      if(curr.next.get((int) prefix.charAt(i)-'a')==null){
        return false;
      }
      curr = curr.next.get((int) prefix.charAt(i)-'a');
    }
    return true;
  }
}
