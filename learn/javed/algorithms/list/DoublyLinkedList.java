package learn.javed.algorithms.list;

/**
 * Doubly linked list supports following function Create list insert element in list find nth element in list from
 * root find nth element in list from tail i.e. reverse find delete any element from list
 * 
 * @author Javed Attar
 *
 */
public class DoublyLinkedList {

  private ListNode root;
  private ListNode tail;

  public void insert(int value) {
    root = _insert(root, null, value);
  }

  private ListNode _insert(ListNode root, ListNode prev, int value) {
    if (root == null) {
      root = new ListNode(value);
      root.prev = prev;
      tail = root;
      return root;
    }
    root.next = _insert(root.next, root, value);
    return root;
  }

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

  public void printReverse() {
    if (root == null) {
      return;
    }
    ListNode indexNode = tail;
    do {
      indexNode.print();
      indexNode = indexNode.prev;
    } while (indexNode.prev != null);
    indexNode.print();
    System.out.println();
  }

  public ListNode findNthElement(int elementPosition) {
    if (root == null)
      return root;
    int counter = 1;
    ListNode requiredNode = root;
    while (counter < elementPosition) {
      if (requiredNode.next == null) {
        return null;
      }
      requiredNode = requiredNode.next;
      counter++;
    }
    return requiredNode;
  }

  public ListNode reverseFindNthElement(int elementPosition) {
    if (tail == null)
      return tail;
    int counter = 1;
    ListNode requiredNode = tail;
    while (counter < elementPosition) {
      if (requiredNode.prev == null) {
        return null;
      }
      requiredNode = requiredNode.prev;
      counter++;
    }
    return requiredNode;
  }

  public boolean delete(int itemValue) {
    if (root == null)
      return false;
    ListNode deleteNode = root;
    while (deleteNode.nodeValue != itemValue) {
      if (deleteNode.next == null) {
        return false;
      }
      deleteNode = deleteNode.next;
    }
    if (deleteNode.prev == null) {
      root = deleteNode.next;
      root.prev = null;
    } else if (deleteNode.next == null) {
      tail = deleteNode.prev;
      tail.next = null;
    } else {
      deleteNode.prev.next = deleteNode.next;
      deleteNode.next.prev = deleteNode.prev;
    }
    return true;
  }

  public ListNode find(int nodeValue) {
    if (root == null) {
      return null;
    }
    ListNode indexNode = root;
    do {
      if (nodeValue == indexNode.nodeValue) {
        return indexNode;
      }
      indexNode = indexNode.next;
    } while (indexNode.next != null);
    if (nodeValue == indexNode.nodeValue) {
      return indexNode;
    }
    return null;
  }

  public DoublyLinkedList clone() {
    DoublyLinkedList dll = new DoublyLinkedList();
    if (root == null) {
      return dll;
    }
    ListNode indexNode = root;
    do {
      dll.insert(new ListNode(indexNode.nodeValue));
      indexNode = indexNode.next;
    } while (indexNode.next != null);
    dll.insert(indexNode);
    // reset to root
    indexNode = root;
    while (indexNode.next != null) {
      if (indexNode.prev != null) {
        ListNode clonedNode = dll.find(indexNode.nodeValue);
        ListNode clonedPrevNode = dll.find(indexNode.prev.nodeValue);
        clonedNode.prev = clonedPrevNode;
      }
      indexNode = indexNode.next;
    }
    if (indexNode.prev != null) {
      ListNode clonedNode = dll.find(indexNode.nodeValue);
      ListNode clonedPrevNode = dll.find(indexNode.prev.nodeValue);
      clonedNode.prev = clonedPrevNode;
    }
    return dll;
  }

  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insert(10);
    dll.insert(20);
    dll.insert(30);
    dll.insert(40);
    dll.insert(50);
    dll.insert(60);
    System.out.println("Original list >> ");
    dll.print();
    System.out.println("Cloned list >> ");
    DoublyLinkedList cloned = dll.clone();
    cloned.print();
    System.out.println("Reverse print list >> ");
    dll.printReverse();
    System.out.print("Find 4th element >> ");
    ListNode foundNode = dll.findNthElement(4);
    printResult(foundNode);
    System.out.print("Find 7th element >> ");
    foundNode = dll.findNthElement(7);
    printResult(foundNode);
    System.out.print("Find 4th element from tail >> ");
    foundNode = dll.reverseFindNthElement(4);
    printResult(foundNode);
    System.out.println("\n\nDelete 50 from list");
    dll.delete(50);
    System.out.print("List after deleting 50 >> ");
    dll.print();
    System.out.println("Delete root");
    dll.delete(10);
    System.out.print("List after deleting root (10) >> ");
    dll.print();
    System.out.println("Delete tail");
    dll.delete(60);
    System.out.print("List after deleting tail (60) >> ");
    dll.print();

  }

  private static void printResult(ListNode foundNode) {
    if (foundNode != null) {
      System.out.println(foundNode.nodeValue);
    } else {
      System.out.println("List size smaller than requested item's position");
    }
  }
}
