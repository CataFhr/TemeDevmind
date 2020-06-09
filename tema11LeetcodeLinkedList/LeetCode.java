package tema11LeetcodeLinkedList;

public class LeetCode {

	// 1.Remove Duplicates from Sorted List

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode it = head;
		while (it.next != null) {
			if (it.val == it.next.val) {
				it.next = it.next.next;
			} else {
				it = it.next;
			}
		}
		return head;
	}

	// 2.Rotate List

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		int size = 0;
		ListNode node = head;
		while (node != null) {
			size++;
			node = node.next;
		}
		for (int i = 0; i < k % size; i++) {
			head = rotate(head);
		}
		return head;
	}

	public ListNode rotate(ListNode head) {
		ListNode newHead = head;
		while (newHead.next.next != null) {
			newHead = newHead.next;
		}
		ListNode lastNode = newHead;
		newHead = newHead.next;
		newHead.next = head;
		lastNode.next = null;
		return newHead;
	}

	// 3.Merge Two Sorted Lists

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head = new ListNode(0);
		ListNode node = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		if (l1 != null) {
			node.next = l1;
		}
		if (l2 != null) {
			node.next = l2;
		}
		return head.next;
	}

	// 4.Remove Duplicates from Sorted List II

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		ListNode cur = head;

		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return newHead.next;
	}

	// 5.Middle of the Linked List

	public ListNode middleNode(ListNode head) {
		int size = 0;
		ListNode it = head;
		while (it != null) {
			size++;
			it = it.next;
		}
		for (int i = 0; i < size / 2; i++) {
			head = head.next;
		}
		return head;

		// Varianta cu 2 point-eri

		if (head.next == null) {
			return head;
		}
		ListNode it1 = head;
		ListNode it2 = head;
		while (it2 != null && it2.next != null) {
			it1 = it1.next;
			it2 = it2.next.next;
		}
		return it1;
	}

	// 6.Reverse Linked List

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode node = new ListNode(head.val);
			node.next = newHead;
			newHead = node;
			head = head.next;
		}
		return newHead;
	}

	// 7.Remove Linked List Elements

	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) { // sarim primele noduri daca au valoarea val
			head = head.next;
		}
		if (head == null) { // verificam daca capul sau noul cap e nul
			return null;
		}

		ListNode node = head;
		while (node.next != null) { // ne oprim la ultimul element
			if (node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}

	// 8.Odd Even Linked List

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

}
