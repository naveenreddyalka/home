package ok.metaprep;

import java.util.Arrays;

public class CoinChange {

  public static void main(String[] args) {
    int[] coins = {186,419,83,408};
    System.out.println(coinChange(coins,6249));
  }
  public static int coinChange(int[] coins, int amount) {
    int change =0;
    Arrays.sort(coins);
    if(amount==0) return change;
    else{
     int n = coins.length;
     int i = n;
     while(amount>0){
       if (i>0 && (amount-coins[i-1])>=0){
         amount = amount - coins[i-1];
         change++;
       }else if(i>0){
         i--;
       }else{
          return -1;
       }
     }
     if(amount==0) return change;

     return -1;
    }
  }
}
