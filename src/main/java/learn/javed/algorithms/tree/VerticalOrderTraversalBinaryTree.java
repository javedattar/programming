/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * 
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row +
 * 1, col + 1) respectively. The root of the tree is at (0, 0).
 * 
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting
 * from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same
 * column. In such a case, sort these nodes by their values.
 * 
 * Return the vertical order traversal of the binary tree.
 * 
 * Examples
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 * 1 is at the top, so it comes first.
 * 5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 * 
 * 
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 *
 */
public class VerticalOrderTraversalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		PriorityQueue<NodeWrapper> pq = new PriorityQueue<>(Comparator.comparingInt((NodeWrapper nw) -> nw.y)
				.thenComparingInt(nw -> nw.x).thenComparingInt(nw -> nw.node.val));
		parseTree(root, 0, 0, pq);

		List<List<Integer>> result = new ArrayList<>();
		int column = pq.peek().y;
		List<Integer> columnList = new ArrayList<>();
		while (!pq.isEmpty()) {
			NodeWrapper nw = pq.peek();
			while (nw.y == column) {
				nw = pq.poll();
				columnList.add(nw.node.val);

				if (pq.isEmpty())
					break;
				nw = pq.peek();

			}
			result.add(columnList);
			columnList = new ArrayList<>();
			column = nw.y;

		}
		return result;
	}

	private void parseTree(TreeNode node, int x, int y, PriorityQueue<NodeWrapper> pq) {
		if (node == null) {
			return;
		}
		NodeWrapper nw = new NodeWrapper(node, x, y);
		pq.add(nw);
		// left node
		parseTree(node.left, x + 1, y - 1, pq);
		// right node
		parseTree(node.right, x + 1, y + 1, pq);
	}

	public class NodeWrapper {
		TreeNode node;
		int x;
		int y;

		public NodeWrapper(TreeNode node, int x, int y) {
			this.x = x;
			this.y = y;
			this.node = node;

		}

		public int hashCode() {
			return Integer.valueOf("" + this.node.val + "" + this.x + "" + this.y);
		}

		public boolean equals(Object obj) {
			NodeWrapper that = (NodeWrapper) obj;
			return this.node.val == that.node.val && this.x == that.x && this.y == that.y;
		}

	}

}
