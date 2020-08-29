package ok.demo.array;

public class MedianSortedArrays {

	public static void main(String[] args) {

	}

	public double sub(int[] nums1, int[] nums2) {

		int l = nums1.length + nums2.length;
		int n = nums1.length;
		int m = nums2.length;
		int min = 0;
		int max = nums1.length;
		int median = 0;
		int i=0;
		int j =0;

		while (min <= max) {

			 i = (min + max) / 2;
			 j = (l + 1) / 2 - i;

			if (i < n && j > 0 && nums2[j - 1] > nums1[i])         
	            min  = i + 1;
			else if (i > 0 && j < m && nums2[j] < nums1[i - 1])         
		        max = i - 1; 
			else {
				if (i == 0)             
	                median = nums2[j - 1]; 
				else if(j==0)
					median = nums1[i - 1]; 
				else
					median = Math.max(nums1[i - 1], nums2[j - 1]);
				break;
			}
		}
		
		
		if ((n + m) % 2 == 1) 
	        return (double)median; 
		
		if (i == n) 
	        return (median+nums2[j]) / 2.0; 
		
		if (j == m) 
	        return (median+nums1[i]) / 2.0; 
		
		return (median + Math.min(nums1[i], nums2[j])) / 2.0; 
	
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length < nums2.length) 
			return sub(nums1, nums2);
		else
			return sub(nums2, nums1);
	}
}
