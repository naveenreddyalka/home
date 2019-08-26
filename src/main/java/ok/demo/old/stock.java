package ok.demo.old;

public class stock {

    public static void main(String[] args) {
        int[] price = {4,2,6,1,3,4,7};
        
        System.out.println(getbestpair(price));
    }
    
    private static int getbestpair(int[] price) {
        int min = price[0];
        int max = -1;
       
        for(int i=0;i<price.length;i++) {
            if(price[i]<min) {
                min = price[i];
            }else {
                if((price[i] - min)>max) {
                    max = price[i] - min;
                }
            }
            
        }
        return max;
    }
    
    
}
