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
		newNode = list.insert(newNode, 0);
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
		while (currNode != newNode.next && newNode.nodeValue <= newNode.next.nodeValue) {
			newNode = newNode.next;
		}
		// once you reach tail, move to next to go to smallest number
		newNode = newNode.next;
		currNode = newNode;
		do {
			System.out.print(newNode.nodeValue + " -> ");

			newNode = newNode.next;
		} while (currNode != newNode);
		System.out.println("\n");
	}

	public ListNode insert(ListNode n, int data) {
		ListNode newNode = new ListNode(data);
		ListNode currNode = n;
		if (n == null) {
			newNode.next = newNode;
			return newNode;
		}
		// get to the smallest element in linked list.
		while (currNode != n.next && n.nodeValue <= n.next.nodeValue) {
			n = n.next;
		}
		n = n.next;
		currNode = n;

		while (currNode != n.next) {
			if (n.nodeValue <= newNode.nodeValue && newNode.nodeValue <= n.next.nodeValue)
				break;
			if (n.nodeValue > n.next.nodeValue)
				break;

			n = n.next;
		}

		newNode.next = n.next;
		n.next = newNode;

		return newNode;
	}

}
