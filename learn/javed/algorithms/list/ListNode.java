package learn.javed.algorithms.list;

/**
 * author: Javed Attar
 */
public class ListNode {
  int nodeValue;
  ListNode next, prev;

  public ListNode(int value) {
    nodeValue = value;
  }

  public void print() {
    System.out.print(String.format("<[%s|%s|%s]>", prev == null ? null : prev.nodeValue, nodeValue,
        next == null ? null : next.nodeValue));
  }
}
