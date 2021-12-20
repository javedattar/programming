/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

public class InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		return _invert(root);
	}

	public TreeNode _invert(TreeNode node) {
		if (node == null) {
			return node;
		}

		_invert(node.left);
		_invert(node.right);
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		return node;
	}
}
