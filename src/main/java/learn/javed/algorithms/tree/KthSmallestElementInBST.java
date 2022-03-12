/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

public class KthSmallestElementInBST {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(56);
		bst.insert(42);
		bst.insert(30);
		bst.insert(20);
		bst.insert(11);
		bst.insert(65);
		bst.insert(7);
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(4);
//		root.left.left.right = new TreeNode(5);
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(6);

		System.out.println(" 3rd smallest element ::> " + new KthSmallestElementInBST().kthSmallest(bst.root, 3));
		System.out.println(" 2nd smallest element ::> " + new KthSmallestElementInBST().kthSmallest(bst.root, 2));
		System.out.println(" outbound smallest element ::> " + new KthSmallestElementInBST().kthSmallest(bst.root, 10));

	}

	int counter = 0;
	int ans = -1;

	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return ans;
	}

	private void inorder(TreeNode node, int k) {
		if (node.left != null)
			inorder(node.left, k);
		counter++;
		if (counter == k) {
			ans = node.val;
			return;
		}
		if (node.right != null)
			inorder(node.right, k);

	}

}
