/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

public class BinaryTreeMaxPathSum {

	public static void main(String[] args) {
		// [4,11,null,7,2]

	}

	int ans = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		find(root);
		return ans;
	}

	private int find(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = find(root.left);
		int right = find(root.right);
		ans = Math.max(Math.max(ans, root.val + left), Math.max(root.val + right, root.val + right + left));
		ans = Math.max(ans, root.val);

		return Math.max(Math.max(left, right) + root.val, root.val);
	}
}
