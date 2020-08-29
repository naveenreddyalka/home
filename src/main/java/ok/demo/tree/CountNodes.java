package ok.demo.tree;

import java.util.ArrayList;
import java.util.List;

public class CountNodes {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> o = new ArrayList<String>();

		if (root == null)
			return o;

		List<String> l = binaryTreePaths(root.left);

		List<String> r = binaryTreePaths(root.right);

		for (String a : l) {
			o.add(root.val + "->" + a);
		}

		for (String a : r) {
			o.add(root.val + "->" + a);
		}

		if (r.isEmpty() && l.isEmpty()) {
			o.add(root.val + "");
		}

		return o;

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
