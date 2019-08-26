package ok.demo.array;

import java.util.ArrayList;
import java.util.List;

public class printallParen {

    public static void main(String[] args) {
        ArrayList<String>  test = new ArrayList<String>();
        getAll(test, 3, 3, new char[6], 0);
        System.out.println(test);
        
    }
    
    private static void getAll(List<String> all,int leftCount, int rightCount, char[] str, int index) {
        if(leftCount<0 || rightCount<leftCount) return;
        
        if(leftCount==0 && rightCount==0) {
            all.add(String.valueOf(str));
        }else {
            
            str[index] =')';
            getAll(all, leftCount, rightCount-1, str, index+1);
            
            str[index] ='(';
            getAll(all, leftCount-1, rightCount, str, index+1);
            
           
            
        }
    }
    
}

