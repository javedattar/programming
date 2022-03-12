/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

import java.util.List;
import java.util.stream.Collectors;

public class LowestCommonAncestor {

	// Given a binary search tree find out lower common ancestor
	public static void main(String[] args) {
		BinarySearchTree bsTree = new BinarySearchTree();
		bsTree.insert(50);
		bsTree.insert(60);
		bsTree.insert(40);
		bsTree.insert(30);
		bsTree.insert(20);
		bsTree.insert(100);
		bsTree.insert(70);
		bsTree.insert(55);
		bsTree.insert(58);
		lowestCommonAncestor(bsTree, 58, 70);
		lowestCommonAncestor(bsTree, 58, 20);
		TreeNode commonNode = lowestCommonAncestor2(bsTree.root, bsTree.search(58, true), bsTree.search(70, true));
		System.out.println(commonNode.val);
		commonNode = lowestCommonAncestor2(bsTree.root, bsTree.search(58, true), bsTree.search(20, true));
		System.out.println(commonNode.val);

	}

	private static void lowestCommonAncestor(BinarySearchTree bsTree, int val1, int val2) {
		bsTree.search(val1, true);
		List<Integer> trackerList = bsTree.trackerList;
		bsTree.search(val2, true);
		List<Integer> trackerList2 = bsTree.trackerList;
		List<Integer> commonNodes = trackerList.stream().filter(val -> trackerList2.contains(val))
				.collect(Collectors.toList());
		System.out.println("Lowest Common ancestor >> " + commonNodes.get(0));
	}

	private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode val1, TreeNode val2) {
		if (root.val > val1.val && root.val > val2.val) {
			return lowestCommonAncestor2(root.left, val1, val2);
		}
		if (root.val < val1.val && root.val < val2.val) {
			return lowestCommonAncestor2(root.right, val1, val2);
		}
		return root;
	}
}
