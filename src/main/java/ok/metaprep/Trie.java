package ok.metaprep;

import java.util.ArrayList;
import java.util.List;

class TNode{
  Character c;
  Boolean isEnd = false;
  List<TNode> next;
  TNode( Character c){
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


  TNode root;

  public Trie() {
    this.root = new TNode(null);
  }

  public void insert(String word) {
    if(word==null) return;
    TNode curr = root;
    for(int i=0; i < word.length();i++){
      if(curr.next.get((int) word.charAt(i)-'a')==null){
        TNode n = new TNode(word.charAt(i));
        curr.next.set((int) word.charAt(i)-'a', n);
      }
      curr = curr.next.get((int) word.charAt(i)-'a');
    }
    curr.isEnd = true;
  }

  public boolean search(String word) {
    if(word==null) return false;
    TNode curr = root;
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
    TNode curr = root;
    for(int i=0; i < prefix.length();i++){
      if(curr.next.get((int) prefix.charAt(i)-'a')==null){
        return false;
      }
      curr = curr.next.get((int) prefix.charAt(i)-'a');
    }
    return true;
  }
}
