package ok.metaprep.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {


  public void backtrack(int index, StringBuilder path, String digits, Map<Character, String[]> letters, List<String> combinations) {
      if (path.length() == digits.length()) {

      combinations.add(path.toString());
      return;
    }

    char digit = digits.charAt(index);
    String[] possibleLetters = letters.get(digit);
    for (String letter : possibleLetters) {

      path.append(letter);

      backtrack(index + 1, path, digits, letters, combinations);

      path.deleteCharAt(path.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits.length() == 0) {
      return combinations;
    }
    Map<Character, String[]> digitsMapping = new HashMap<>();
    digitsMapping.put('1', new String[]{""});
    digitsMapping.put('2', new String[]{"a", "b", "c"});
    digitsMapping.put('3', new String[]{"d", "e", "f"});
    digitsMapping.put('4', new String[]{"g", "h", "i"});
    digitsMapping.put('5', new String[]{"j", "k", "l"});
    digitsMapping.put('6', new String[]{"m", "n", "o"});
    digitsMapping.put('7', new String[]{"p", "q", "r", "s"});
    digitsMapping.put('8', new String[]{"t", "u", "v"});
    digitsMapping.put('9', new String[]{"w", "x", "y", "z"});


    backtrack(0, new StringBuilder(), digits, digitsMapping, combinations);

    return combinations;
  }


  public void backtrack2(int index, StringBuilder path, String digits, Map<Character, String[]> letters, List<String> combinations) {
   if( path.length() == digits.length()) {
     combinations.add(path.toString());
     return;
   }

   char digit = digits.charAt(index);
   String[] curr_letters = letters.get(digit);
    for(int i=0; i<curr_letters.length; i++) {
      path.append(curr_letters[i]);
      backtrack2(index+1, path, digits, letters, combinations);
      path.deleteCharAt(path.length() - 1);
    }

  }


  public static void main(String[] args){

    int[] digits = {2,3,4,5,6,7,8,9};
    List<Integer> l = new ArrayList(Arrays.asList(digits));
    LetterCombinationsPhoneNumber sol = new LetterCombinationsPhoneNumber();
    String[] digitsArray = {"23", "73", "426", "78", "925", "2345"};
    for(int i = 0; i < digitsArray.length; i++){
      System.out.println((i + 1)+ ".\tAll letter combinations for  "+digitsArray[i]+ ": "+ sol.letterCombinations(digitsArray[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }

}
