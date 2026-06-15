/**
 * Description: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */

public class DeleteTheMiddleNodeOfALinkedList {

	public ListNode deleteMiddle(ListNode head) {
		if (head.next == null) {
			return null;
		}

		ListNode slow = head, fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
