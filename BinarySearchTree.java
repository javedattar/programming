/**
 * 
 * @author Javed Attar
 *
 */
public class BinarySearchTree {
  TreeNode root;

  class TreeNode {
    int nodeValue;
    TreeNode leftNode, rightNode;

    public TreeNode(int value) {
      nodeValue = value;
    }
  }

  public void insert(int value) {
    root = insertItem(root, value);
  }

  private TreeNode insertItem(TreeNode currentNode, int value) {
    if (currentNode == null) {
      currentNode = new TreeNode(value);
      return currentNode;
    }
    if (currentNode.nodeValue < value) {
      currentNode.rightNode = insertItem(currentNode.rightNode, value);
    } else {
      currentNode.leftNode = insertItem(currentNode.leftNode, value);
    }
    return currentNode;
  }

  public TreeNode search(int searchValue) {
    return _search(root, searchValue);
  }

  private TreeNode _search(TreeNode currentNode, int searchValue) {
    if (currentNode == null) {
      System.out.println("Didn't find what you are looking for");
      return currentNode;
    }
    if (searchValue == currentNode.nodeValue) {
      System.out.println(String.format("Tree has number %d present in it", searchValue));
      return currentNode;
    }
    if (searchValue > currentNode.nodeValue) {
      return _search(currentNode.rightNode, searchValue);
    }
    return _search(currentNode.leftNode, searchValue);
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
    _inOrderTraversal(currentNode.leftNode);
    System.out.println(currentNode.nodeValue);
    _inOrderTraversal(currentNode.rightNode);
  }

  private void _preOrderTraversal(TreeNode currentNode) {
    if (currentNode == null) {
      return;
    }
    System.out.println(currentNode.nodeValue);
    _preOrderTraversal(currentNode.leftNode);
    _preOrderTraversal(currentNode.rightNode);
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
    System.out.println(bsTree.root.nodeValue);
    bsTree.search(20);
    bsTree.search(58);
    bsTree.search(99);
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
