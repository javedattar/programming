/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

import java.util.List;
import java.util.stream.Collectors;

import learn.javed.algorithms.tree.BinarySearchTree.TreeNode;

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
		longestCommonAncestor(bsTree, 58, 70);
		longestCommonAncestor(bsTree, 58, 20);
		TreeNode commonNode = longestCommonAncestor2(bsTree.root, bsTree.search(58, true), bsTree.search(70, true));
		System.out.println(commonNode.nodeValue);
		commonNode = longestCommonAncestor2(bsTree.root, bsTree.search(58, true), bsTree.search(20, true));
		System.out.println(commonNode.nodeValue);

	}

	private static void longestCommonAncestor(BinarySearchTree bsTree, int val1, int val2) {
		bsTree.search(val1, true);
		List<Integer> trackerList = bsTree.trackerList;
		bsTree.search(val2, true);
		List<Integer> trackerList2 = bsTree.trackerList;
		List<Integer> commonNodes = trackerList.stream().filter(val -> trackerList2.contains(val))
				.collect(Collectors.toList());
		System.out.println("Lowest Common ancestor >> " + commonNodes.get(0));
	}

	private static BinarySearchTree.TreeNode longestCommonAncestor2(BinarySearchTree.TreeNode root,
			BinarySearchTree.TreeNode val1, BinarySearchTree.TreeNode val2) {
		if (root.nodeValue > val1.nodeValue && root.nodeValue > val2.nodeValue) {
			return longestCommonAncestor2(root.leftNode, val1, val2);
		}
		if (root.nodeValue < val1.nodeValue && root.nodeValue < val2.nodeValue) {
			return longestCommonAncestor2(root.rightNode, val1, val2);
		}
		return root;
	}
}
