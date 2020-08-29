package ok.test;

public class magicstring {

	public static int[] magic;
	public static int count1  = 0;
	
	public static void main(String[] args) {
		magic = new int[6];
		magic[0] =1;
		count1++;
		fillNext(0, 1, 4);
		System.out.println(count1);
	}
	
	private static void fillNext(int i, int j, int max) {
		if(j>=max) return;
		
		if(magic[i]==1) {
			if(magic[j-1]==1) magic[j]= 2;
			if(magic[j-1]==2) {
				magic[j]= 1;
				count1++;
			}
			j++;
			i++;
		}else {
			magic[j] = magic[j-1];
			
			if(j+1>=max) {
				if(magic[j]==1) {
					count1++;
				}
				return;
			}
			
			if(magic[j]==1) {
				magic[j+1]= 2;
				count1++;
			}
			if(magic[j]==2) {
				magic[j+1]= 1;
				count1++;
			}
			
			i++;
			j = j+2;
		}
		fillNext(i, j, max);
	}
}
