package ok.metaprep;

public class HappyNumber {

  public static void main(String[] args) {

    System.out.println(isHappyNumber(28));
  }

  public static boolean isHappyNumber(int n) {

   int slow = n, fast = n;
   while(fast != 1 && slow!=1){
      slow = sumSquare(slow);
      fast = sumSquare(sumSquare(fast));
     if(fast == slow) return false;
   }
    return true;
  }

  public static int sumSquare(int n){
    int sum =0;
    while(n>0){
      int r = n%10;
      sum += r*r;
      n = n/10;
    }
    return sum;
  }
}
