package ok.demo;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class walmart {
    int intialSize = 10;
    int loadFactor = 50;
    public int[] intAry = new int[intialSize];
    int size = 0;
    
    public void add(int intValue){
        intAry[size] = intValue;
        size++;
        if(checkLoad()){
            reSize();
        }
        
    }
    
    public int get(int index){
        if(index>intAry.length){
            throw new RuntimeException("Array length exceeds");
        }
        return intAry[index];
    }
    
    public boolean delete(int index){
       if(index>intAry.length){
            throw new RuntimeException("Array length exceeds");
        } 
        for(int i=index;i<intAry.length;i++){
            intAry[index] = intAry[index+1];
        }
        return true;
    }
    
    private boolean checkLoad(){
        return ((size * 100 )/intAry.length) > loadFactor;
    }
    
    private void reSize(){
        int[] newAry = new int[intAry.length*2];
        for(int i=0;i<intAry.length;i++){
            newAry[i] = intAry[i];
        }
        newAry = newAry;
    }
   
   public static void main(String args[] ) throws Exception {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       walmart s = new walmart();
       for(int i=0;i<=12;i++){
            s.add(i);
       }
      System.out.println(Arrays.toString(s.intAry));
   }
   
   
   
}
