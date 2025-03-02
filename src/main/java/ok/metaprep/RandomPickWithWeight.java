package ok.metaprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
  Random random =  new Random();
  double[] p;
  int[] w;

  public static void main(String[] args) {
    RandomPickWithWeight p = new RandomPickWithWeight(new int[]{1,2,3,4});
    System.out.println(p.pickIndex());
  }

  public RandomPickWithWeight(int[] w) {
    double sum = 0;
    for(int i : w){
      sum = sum + i;
    }
    this.w = w;
    this.p = new double[w.length];
    p[0] = w[0]/sum;
    for(int i=1; i<w.length; i++){
      p[i] = p[i-1] + w[i]/sum;
    }
  }

  public int pickIndex() {
    double seed = random.nextDouble();
    int l = 0, r = p.length-1;
    while(l<r){
      int m = l + (r-l)/2;
     if (p[m] < seed) {
       l = m+1;
     }else{
       r=m;
     }
    }
    return l;
  }
}
