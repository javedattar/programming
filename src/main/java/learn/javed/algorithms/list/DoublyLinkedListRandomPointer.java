package learn.javed.algorithms.list;

/**
 * Create doubly linked list with random previous pointer and clone that list.
 * 
 * author: Javed Attar
 */

public class DoublyLinkedListRandomPointer {

  private ListNode root;
  private ListNode tail;

  public void insert(ListNode node) {
    if (root == null) {
      root = node;
      tail = node;
      return;
    }
    ListNode indexNode = root;
    while (indexNode.next != null) {
      indexNode = indexNode.next;
    }
    indexNode.next = node;
    tail = node;
  }

  public void print() {
    if (root == null) {
      return;
    }
    ListNode indexNode = root;
    do {
      indexNode.print();
      indexNode = indexNode.next;
    } while (indexNode.next != null);
    indexNode.print();
    System.out.println();
  }

  public ListNode find(int nodeValue) {
    if (root == null) {
      return null;
    }
    ListNode indexNode = root;
    while (indexNode.next != null) {
      if (nodeValue == indexNode.nodeValue) {
        return indexNode;
      }
      indexNode = indexNode.next;
    }
    if (nodeValue == indexNode.nodeValue) {
      return indexNode;
    }
    return null;
  }

  public DoublyLinkedListRandomPointer clone() {
    DoublyLinkedListRandomPointer dll = new DoublyLinkedListRandomPointer();
    if (root == null) {
      return dll;
    }
    ListNode indexNode = root;
    do {
      dll.insert(new ListNode(indexNode.nodeValue));
      indexNode = indexNode.next;
    } while (indexNode.next != null);
    dll.insert(new ListNode(indexNode.nodeValue));
    // reset to root
    indexNode = root;
    while (indexNode.next != null) {
      _processPreviousNodeClone(dll, indexNode);
      indexNode = indexNode.next;
    }
    _processPreviousNodeClone(dll, indexNode);
    return dll;
  }

  private void _processPreviousNodeClone(DoublyLinkedListRandomPointer dll, ListNode indexNode) {
    if (indexNode.prev != null) {
      ListNode clonedNode = dll.find(indexNode.nodeValue);
      ListNode clonedPrevNode = dll.find(indexNode.prev.nodeValue);
      clonedNode.prev = clonedPrevNode;
    }
  }

  public static void main(String[] args) {
    DoublyLinkedListRandomPointer dll = new DoublyLinkedListRandomPointer();
    // Create nodes
    ListNode node1 = new ListNode(10);
    ListNode node2 = new ListNode(20);
    ListNode node3 = new ListNode(30);
    ListNode node4 = new ListNode(40);
    ListNode node5 = new ListNode(50);
    ListNode node6 = new ListNode(60);
    ListNode node7 = new ListNode(70);
    // insert nodes
    dll.insert(node1);
    dll.insert(node2);
    dll.insert(node3);
    dll.insert(node4);
    dll.insert(node5);
    dll.insert(node6);
    dll.insert(node7);
    // set previous pointer to random nodes
    node2.prev = node4;
    node6.prev = node1;
    node5.prev = node2;
    node7.prev = node3;
    node3.prev = node7;
    node4.prev = node6;
    System.out.println("Original list");
    dll.print();
    System.out.println("Cloned list");
    dll.clone().print();
  }
}
