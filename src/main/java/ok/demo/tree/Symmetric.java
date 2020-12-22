package ok.demo.tree;

import java.util.ArrayList;

import ok.demo.linkedlist.ll;

public class Symmetric {

	public static void main(String[] args) {
		// -------7-------
		// ----3------11---
		// --1---5----9---13
		// -n-2-4-6-8-10-12-14
		// int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int[] test = { 1, 2, 3, 4, 5, 1, 2, 3, 4 };
		node root = buildminbst.getbstNice(test, 0, test.length - 1);
		System.out.println(isSymmetric(root));
	}

	private static boolean isSymmetric(node head) {
		if (head == null)
			return true;

		if (head.getLeft() == null && head.getRight() == null)
			return true;

		if (head.getLeft() == null || head.getLeft() == null)
			return false;

		if (head.getLeft().getValue() == head.getRight().getValue())
			return true;

		return false;
	}
	
	private static boolean search(int[][] dict, int a) {
		int l = dict.length;
		int m = dict[0].length;
		int i =0;
		int j =0;
		
		while(i>=0 && i<l && j>=0 && j<m) {
			if(dict[i][j]==a) return true;
			else {
				
			}
			
			
			
		}
		
		
		return false;
	}

}
