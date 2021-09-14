
class AddLinkedListNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    System.out.println("parse list 1 and reverse");
    int num1 = reverseNumber(parseList(l1));
    System.out.println("Num 1 :> " + num1);
    System.out.println("parse list 2 and reverse");
    int num2 = reverseNumber(parseList(l2));
    System.out.println("Num 2 :> " + num2);
    int result = num1 + num2;
    System.out.println("result :> " + result);
    return buildListFromNumber(result);
  }

  public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
    }

    void setNext(ListNode nextItem) {
      next = nextItem;
    }

    void appendToList(int value) {
      ListNode head = this;
      ListNode append = new ListNode(value);
      while (head.next != null) {
        head = this.next;
      }
      head.next = append;
    }

    void print() {
      ListNode head = this;
      while (head.next != null) {
        System.out.print(head.val + "->");
        head = head.next;
      }
      System.out.print(head.val);
      System.out.print("\n");
    }
  }

  private int appendNumber(int number, int numberToAppend) {
    return number * 10 + numberToAppend;
  }

  private int reverseNumber(int number) {
    int result = 0;
    int tail = 0;
    int number2 = number;
    while (number2 != 0) {
      tail = number2 % 10;
      result = appendNumber(result, tail);
      number2 = number2 / 10;
    }
    return result;
  }

  private ListNode buildListFromNumber(int number) {
    ListNode l = intializeLinkedList(0);
    ListNode head = l;
    int tail = 0;
    int number2 = number;
    while (number2 != 0) {
      tail = number2 % 10;
      l.val = tail;
      number2 = number2 / 10;
      if (number2 != 0) {
        l.appendToList(0);
        l = l.next;
      }

    }
    head.print();
    return head;
  }


  private ListNode intializeLinkedList(int value) {
    return new ListNode(value);
  }

  private int parseList(ListNode l) {
    int result = 0;
    ListNode head = l;
    while (head.next != null) {
      result = appendNumber(result, head.val);
      head = head.next;
    }
    result = appendNumber(result, head.val);
    return result;
  }

  public static void main(String[] args) {
    AddLinkedListNumbers s = new AddLinkedListNumbers();
    System.out.println("Start list 1");
    AddLinkedListNumbers.ListNode l1 = s.buildListFromNumber(342);
    System.out.println("Start list 2");
    ListNode l2 = s.buildListFromNumber(465);
    s.addTwoNumbers(l1, l2);
  }
}
