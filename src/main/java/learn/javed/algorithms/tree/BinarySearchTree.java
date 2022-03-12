package learn.javed.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Javed Attar
 *
 */
public class BinarySearchTree {
	TreeNode root;
	List<Integer> trackerList;

//	class TreeNode {
//		int val;
//		TreeNode left, right;
//
//		public TreeNode(int value) {
//			val = value;
//		}
//	}

	public void insert(int value) {
		root = insertItem(root, value);
	}

	private TreeNode insertItem(TreeNode currentNode, int value) {
		if (currentNode == null) {
			currentNode = new TreeNode(value);
			return currentNode;
		}
		if (currentNode.val < value) {
			currentNode.right = insertItem(currentNode.right, value);
		} else {
			currentNode.left = insertItem(currentNode.left, value);
		}
		return currentNode;
	}

	public TreeNode search(int searchValue, boolean doTrack) {
		trackerList = new ArrayList<>();
		TreeNode node = _search(root, searchValue, doTrack);
		trackerList.add(root.val);
		return node;
	}

	private TreeNode _search(TreeNode currentNode, int searchValue, boolean doTrack) {
		if (currentNode == null) {
			System.out.println("Couldn't find the number " + searchValue);
			return currentNode;
		}
		if (searchValue == currentNode.val) {
			System.out.println(String.format("Tree has number %d present in it", searchValue));
			return currentNode;
		}
		if (searchValue > currentNode.val) {
			TreeNode node = _search(currentNode.right, searchValue, doTrack);
			if (currentNode.right != null)
				this.trackerList.add(currentNode.right.val);
			return node;
		}
		TreeNode node = _search(currentNode.left, searchValue, doTrack);
		if (currentNode.left != null)
			this.trackerList.add(currentNode.left.val);
		return node;
	}

	public void inOrderTraversal() {

		_inOrderTraversal(root);
	}

	public void preOrderTraversal() {

		_preOrderTraversal(root);
	}

	private void _inOrderTraversal(TreeNode currentNode) {
		if (currentNode == null) {
			return;
		}
		_inOrderTraversal(currentNode.left);
		System.out.println(currentNode.val);
		_inOrderTraversal(currentNode.right);
	}

	private void _preOrderTraversal(TreeNode currentNode) {
		if (currentNode == null) {
			return;
		}
		System.out.println(currentNode.val);
		_preOrderTraversal(currentNode.left);
		_preOrderTraversal(currentNode.right);
	}

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
		System.out.println("Root Node >> " + bsTree.root.val);
		bsTree.search(20, true);
		System.out.println("Tracker list" + bsTree.trackerList);
		bsTree.search(58, false);
		bsTree.search(99, true);
		System.out.println("Tracker list" + bsTree.trackerList);
		System.out.println("InOrder Traversal");
		bsTree.inOrderTraversal();
		System.out.println("PreOrder Traversal");
		bsTree.preOrderTraversal();
		BinarySearchTree bsTree2 = new BinarySearchTree();
		bsTree2.insert(5);
		bsTree2.insert(3);
		bsTree2.insert(4);
		bsTree2.insert(1);
		bsTree2.insert(2);
		bsTree2.insert(0);
		bsTree2.insert(8);
		bsTree2.insert(6);
		bsTree2.insert(9);
		bsTree2.insert(7);
		System.out.println("InOrder Traversal 2");
		bsTree2.inOrderTraversal();
		System.out.println("PreOrder Traversal 2");
		bsTree2.preOrderTraversal();

	}

}
