package ok.metaprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNA {

  public static void main(String[] args) {
    //Set<String> results = findRepeatedSequencesWithList("AAAAACCCCCAAAAACCCCCC",8);
    //System.out.println(results);
    /*
    * 1212
    * 1 * 2^1 + 2 * 2^2
    * ([1 * 2^1 + 2 * 2^2 ] - 1 * 2^1) * 2
    * */

    //GTAATGTAATATAGGAGAGTATGCACAGGACTCTAGGATCCTCCCAGACCCCGGGCTGACACAAAGTTCTAATAGGTACGG
//GTAATAGTACGG
    System.out.println(findRepeatedSequencesRight("AAAAACCCCCAAAAACCCCCC",8));
  }

  public static Set<String> findRepeatedSequencesRight(String dna, int k){
    if(dna==null || dna.length()==0 || k>dna.length()) return new HashSet<>();

    Set<Long> seen = new HashSet<>();

    List<Integer> dna_num = new ArrayList<>();
    for(Character c: dna.toCharArray()){
      int t = c-'A';
      dna_num.add(t + 1);
    }
    int base = 26;
    Deque<Integer> dna_win = new ArrayDeque<>();
    long key = 0;
    for(int i=0; i<k;i++){
      dna_win.addLast(dna_num.get(i));
      key = key + dna_num.get(i) * (long) Math.pow(base,k-(i+1));
    }
    seen.add(key);
    List<Integer> result = new ArrayList<>();
    for(int i=1;i<dna_num.size()-k+1;i++){
      long reduce = dna_num.get(i-1) * (long) Math.pow(base,k-1);
      key = (key - reduce)*base + dna_num.get(i+k-1);
      if(seen.contains(key)) result.add(i);
      else seen.add(key);
    }

    Set<String> result_strings = new HashSet<>();
    for(int i=0; i<result.size();i++){
      int start = result.get(i);
      result_strings.add(dna.substring(start,start+k));
    }

    return result_strings;
  }



  // Look at this one
  public static void findRepeatedSequences2(String dna, int k) {

    int stringLength = dna.length();

    // Mapping of characters
    Map<Character, Integer> mapping = new HashMap<>();
    mapping.put('A', 1);
    mapping.put('C', 2);
    mapping.put('G', 3);
    mapping.put('T', 4);

    // Base value
    int baseValue = 4;

    // Numeric representation of the sequence
    List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[stringLength]));
    Arrays.fill(numbers.toArray(), 0);
    for (int i = 0; i < stringLength; i++) {
      numbers.set(i, mapping.get(dna.charAt(i)));
    }

    // Current hash value
    int hashValue = 0;

    for (int i = 0; i < stringLength - k + 1; i++) {

      // If the window is at its initial position, calculate the hash value from scratch
      if (i == 0) {
        for (int j = 0; j < k; j++) {
          hashValue += numbers.get(j) * (int) Math.pow(baseValue, k - j - 1);
        }
      } else {
        int previousHashValue = hashValue;
        hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(baseValue, k - 1)) * baseValue) + numbers.get(i + k - 1);
      }

      System.out.println("\tHash value of " + dna.substring(i, i + k) + ": " + hashValue);
    }
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    int L = 10, n = s.length();
    HashSet<String> seen = new HashSet(), output = new HashSet();

    // iterate over all sequences of length L
    for (int start = 0; start < n - L + 1; ++start) {
      String tmp = s.substring(start, start + L);
      if (seen.contains(tmp)) output.add(tmp);
      seen.add(tmp);
    }
    return new ArrayList<String>(output);
  }


  public static Set<String> findRepeatedSequencesWithList(String dna, int k) {
    Set<String> result = new HashSet<>();
    if(dna==null || dna.length()<k+1) return result;

    Set<String> alreadySeen = new HashSet<>();
    LinkedList<Character> window = new LinkedList<>();
    for(int i=0;i<k;i++){
      window.add(dna.charAt(i));
    }
    alreadySeen.add(Arrays.toString(window.toArray( new Character[0])));

    for(int i=k;i<dna.length()-1;i++){
      window.addLast(dna.charAt(i));
      window.removeFirst();
      if(alreadySeen.contains(Arrays.toString(window.toArray( new Character[0])))){
        StringBuilder sb = new StringBuilder();
        for (Character ch : window) {
          sb.append(ch);
        }
        String windowString = sb.toString();
        result.add(windowString);
      }else{
        alreadySeen.add(Arrays.toString(window.toArray( new Character[0])));
      }

    }
    return result;
  }

  public static Set<String> findRepeatedSequences(String dna, int k) {
    Set<Character[]> alreadySeen = new HashSet<>();
    List<Character> window = new ArrayList<>();
    for(int i=0;i<k-1;i++){
      window.add(dna.charAt(i));
    }
    alreadySeen.add(window.toArray( new Character[0]));
    return new HashSet<String>();
  }
}
