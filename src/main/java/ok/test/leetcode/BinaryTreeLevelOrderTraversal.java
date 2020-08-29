package ok.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode r7 = new TreeNode(7);
		TreeNode l15 = new TreeNode(15);
		TreeNode r20 = new TreeNode(20);
		r20.left = l15;
		r20.right = r7;
		TreeNode l9 = new TreeNode(9);
		TreeNode root = new TreeNode(3);
		root.left = l9;
		root.right = r20;
		levelOrderBottom(root);
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		if(root == null) return ret;
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		que.add(null);
		List<Integer> level = new ArrayList<Integer>();
		
		while(!que.isEmpty()) {
			TreeNode n = que.poll();
			if(n==null) {
				if(!que.isEmpty()) que.add(null);
				ret.add(new ArrayList<Integer>(level));
				level = new ArrayList<Integer>(); 
			}else {
				level.add(n.val);
				if(n.left!=null) que.add(n.left);
				if(n.right!=null) que.add(n.right);
			}
		}
		Collections.reverse(ret);
		return ret;
	}

}
