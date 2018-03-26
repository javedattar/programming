/**
 * author: Javed Attar
 */

public class SerializeBinarySearchTree {

  static TreeNode root;
  static String serializedTree = "";

  public static String serialize(TreeNode root) {
    int level = 1;
    while (level <= height(root)) {
      _serialize(root, level);
      level++;
    }
    System.out.println(serializedTree);
    return serializedTree;
  }

  private static void _serialize(TreeNode root, int level) {
    if (root == null) {
      serializedTree += "#,";
      return;
    }
    if (level == 1) {
      serializedTree += root.val + ",";
    } else if (level > 1) {
      _serialize(root.left, level - 1);
      _serialize(root.right, level - 1);
    }
  }

  public static TreeNode deserialize(String serializedTree) {
    String[] numbers = serializedTree.split(",");
    System.out.println(numbers.length);
    TreeNode localRoot = new TreeNode(Integer.parseInt(numbers[0]));
    _addChildren(localRoot, 0, numbers);
    return localRoot;
  }

  private static void _addChildren(TreeNode parentNode, int nodePosition, String[] numbers) {
    if (numbers[nodePosition].equals("#")) {
      return;
    }
    int leftChildPosition = 2 * nodePosition + 1;
    if (leftChildPosition < numbers.length && numbers[leftChildPosition].equals("#") == false) {
      parentNode.left = new TreeNode(Integer.parseInt(numbers[leftChildPosition]));
      _addChildren(parentNode.left, leftChildPosition, numbers);
    }
    int rightChildPosition = 2 * nodePosition + 2;
    if (rightChildPosition < numbers.length && numbers[rightChildPosition].equals("#") == false) {
      parentNode.right = new TreeNode(Integer.parseInt(numbers[rightChildPosition]));
      _addChildren(parentNode.right, rightChildPosition, numbers);
    }
  }

  private static int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static void main(String[] args) {
    // Construct Tree
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    String serializeTree = serialize(root);
    TreeNode deserializeRoot = deserialize(serializeTree);
    System.out.println(deserializeRoot.val);
    System.out.println(deserializeRoot.left.val);
    System.out.println(deserializeRoot.left.left.val);
    System.out.println(deserializeRoot.left.left.right.val);
    System.out.println(deserializeRoot.right.val);
    System.out.println(deserializeRoot.right.left.val);
    serializedTree = "";
    serialize(deserializeRoot);
  }
}
