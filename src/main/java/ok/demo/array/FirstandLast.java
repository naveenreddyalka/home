package ok.demo.array;

public class FirstandLast {

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		System.out.println(searchRange(nums, 6));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] re = new int[2]; re[0] = -1; re[1] = -1;
		if(nums.length==0) return re;
		int l = 0;
		int h = nums.length-1;
		while (l <= h) {
			int m = (l + h) / 2;
			int n = nums[m];
			if (n < target) {
				l = m+1;
			} else if (n > target) {
				h = m-1;
			} else {
				re[1] = m;
				if(re[1]<nums.length-1 && nums[re[1]+1]==target) {
					l =re[1]+1;
				}else {
					break;
				} 
			}

		}
		
		l = 0;
		h = nums.length-1;
		
		while (l <= h) {
			int m = (l + h) / 2;
			int n = nums[m];
			if (n < target) {
				l = m+1;
			} else if (n > target) {
				h = m-1;
			} else {
				re[0] = m;
				if(re[0]>0 && nums[re[0]-1]==target) {
					h =re[0]-1;
				}else {
					break;
				} 
			}

		}

		return re;
	}
}
