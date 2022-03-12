/**
* author: Javed Attar
*/
package learn.javed.algorithms.list;

public class SortedCircularLinkedList {

	public static void main(String[] args) {

		SortedCircularLinkedList list = new SortedCircularLinkedList();
		ListNode newNode = list.insert(null, 5);
		print(newNode);
		newNode = list.insert(newNode, 3);
		print(newNode);
		ListNode newNode2 = list.insert(newNode, 2);
		print(newNode);
		newNode = list.insert(newNode2, 12);
		print(newNode);
		newNode = list.insert(newNode, 2);
		print(newNode);
		newNode = list.insert(newNode, 3);
		print(newNode);
		newNode = list.insert(newNode, 4);
		print(newNode);
		newNode = list.insert(newNode, 5);
		print(newNode);
		newNode = list.insert(newNode, 13);
		print(newNode);
		newNode = list.insert(null, 10);
		newNode = list.insert(newNode, 10);
		newNode = list.insert(newNode, 10);
		newNode = list.insert(newNode, 10);
		newNode = list.insert(newNode, 10);
		newNode = list.insert(newNode, 10);
		newNode = list.insert(newNode, 1);
		newNode = list.insert(newNode, 2);
		print(newNode);
		newNode = list.insert(newNode, 20);
		print(newNode);

	}

	private static void print(ListNode newNode) {
		ListNode currNode = newNode;

		while (true) {
			System.out.print(newNode.nodeValue + " -> ");
			if (currNode.equals(newNode.next))
				break;
			newNode = newNode.next;
		}
		System.out.println("\n");
	}

	public ListNode insert(ListNode n, int data) {
		ListNode newNode = new ListNode(data);
		ListNode currNode = n;
		if (n == null) {
			newNode.next = newNode;
			return newNode;
		}
		ListNode prev = null;

		while (true) {
			if (n.nodeValue <= newNode.nodeValue && newNode.nodeValue <= n.next.nodeValue)
				break;
			if (n.nodeValue > n.next.nodeValue && newNode.nodeValue > n.nodeValue)
				break;
			prev = n;

			if (currNode.equals(n.next)) {
				newNode.next = prev.next;
				prev.next = newNode;
				return newNode;
			}
			n = n.next;
		}
		newNode.next = n.next;
		n.next = newNode;

		return newNode;
	}

}
