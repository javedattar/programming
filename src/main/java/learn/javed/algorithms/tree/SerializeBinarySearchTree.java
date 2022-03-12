package learn.javed.algorithms.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Serialize BST such a way that it can be deserialzed back to BST.
 * 
 * To serialize we are going to do level order traversing and add missing nodes as # instead of nulls. With this
 * approach a BST becomes complete BST.
 * 
 * To deserialize create array out of serialized input string by tokenizing on comma. Every will have children
 * either number or #, if number created node and add to tree. If # then don't create that node
 * 
 * author: Javed Attar
 */

public class SerializeBinarySearchTree {

	static TreeNode root;
	List<String> serializedTree = new ArrayList<>();

//	public String serialize(TreeNode root) {
//
//		int level = 1;
//		int treeHeight = height(root);
//		while (level <= treeHeight) {
//			_serialize(root, level);
//			level++;
//		}
//		System.out.println("Serialized output >> " + serializedTree);
//		return String.join(",", serializedTree);
//	}
//
//	private void _serialize(TreeNode root, int level) {
//		if (root == null) {
//			serializedTree.add("-1");
//			return;
//		}
//		if (level == 1) {
//			serializedTree.add("" + root.val);
//		} else if (level > 1) {
//			_serialize(root.left, level - 1);
//			_serialize(root.right, level - 1);
//		}
//	}
//
//	public TreeNode deserialize(String data) {
//		if (data == null || data.isEmpty())
//			return null;
//		String[] numbers = data.split(",");
//		TreeNode localRoot = new TreeNode(Integer.parseInt(numbers[0]));
//		_addChildren(localRoot, 0, numbers);
//		return localRoot;
//	}
//
//	private void _addChildren(TreeNode parentNode, int nodePosition, String[] numbers) {
//		if (numbers[nodePosition].equals("-1")) {
//			return;
//		}
//		int leftChildPosition = 2 * nodePosition + 1;
//		if (leftChildPosition < numbers.length && numbers[leftChildPosition].equals("-1") == false) {
//			parentNode.left = new TreeNode(Integer.parseInt(numbers[leftChildPosition]));
//			_addChildren(parentNode.left, leftChildPosition, numbers);
//		}
//		int rightChildPosition = 2 * nodePosition + 2;
//		if (rightChildPosition < numbers.length && numbers[rightChildPosition].equals("-1") == false) {
//			parentNode.right = new TreeNode(Integer.parseInt(numbers[rightChildPosition]));
//			_addChildren(parentNode.right, rightChildPosition, numbers);
//		}
//	}
//
//	private int height(TreeNode node) {
//		if (node == null) {
//			return 0;
//		}
//		int leftHeight = height(node.left);
//		int rightHeight = height(node.right);
//		return 1 + Math.max(leftHeight, rightHeight);
//	}

	public static void main(String[] args) {
		SerializeBinarySearchTree bs = new SerializeBinarySearchTree();
		// Construct Tree
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		String serializeTree = bs.serialize(root);
		TreeNode deserializeRoot = bs.deserialize(serializeTree);
		System.out.println("Deserialzed output >> ");
		System.out.println(deserializeRoot.val);
		System.out.println(deserializeRoot.left.val);
		System.out.println(deserializeRoot.left.left.val);
		System.out.println(deserializeRoot.left.left.right.val);
		System.out.println(deserializeRoot.right.val);
		System.out.println(deserializeRoot.right.left.val);
//    serializedTree = "";
//    serialize(deserializeRoot);
	}

	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		List<String> serializedNodes = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		queue.add(new TreeNode(Integer.MIN_VALUE));
		_serialize(queue, serializedNodes);
		System.out.println(String.join(",", serializedNodes));
		return String.join(",", serializedNodes);
	}

	private static void _serialize(Deque<TreeNode> queue, List<String> serializedNodes) {
		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			if (node.val == Integer.MIN_VALUE) {
				if (!queue.isEmpty())
					queue.add(new TreeNode(Integer.MIN_VALUE));
				continue;
			}
			if (node.val == -1) {
				serializedNodes.add("-1");
				continue;
			}
			serializedNodes.add("" + node.val);

			if (node.left == null)
				queue.offer(new TreeNode(-1));
			else
				queue.offer(node.left);

			if (node.right == null)
				queue.offer(new TreeNode(-1));
			else
				queue.offer(node.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] serializedNodes = data.split(",");

		return _insert(null, 0, serializedNodes);
	}

	private TreeNode _insert(TreeNode node, int index, String[] serializedNodes) {
		if (index >= serializedNodes.length || serializedNodes[index].isEmpty())
			return null;

		int val = Integer.parseInt(serializedNodes[index]);
		if (val == -1)
			return null;

		node = new TreeNode(val);

		node.left = _insert(node.left, 2 * index + 1, serializedNodes);
		node.right = _insert(node.right, 2 * index + 2, serializedNodes);
		;
		return node;
	}

}
