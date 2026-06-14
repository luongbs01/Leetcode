/**
 * Description: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */

public class MaximumTwinSumOfALinkedList {

	public int pairSum(ListNode head) {
		ListNode tail1 = head, tail2 = head.next, head2;
		while (tail2.next != null && tail2.next.next != null) {
			tail1 = tail1.next;
			tail2 = tail2.next.next;
		}
		tail2 = new ListNode(0, tail1.next);
		tail1.next = null;
		head2 = tail2.next;

		while (head2 != null) {
			ListNode newHead2 = head2.next;
			head2.next = tail2;
			tail2 = head2;
			head2 = newHead2;
		}

		head2 = tail2;
		int ans = 0;
		while (head != null) {
			ans = Math.max(ans, head.val + head2.val);
			head = head.next;
			head2 = head2.next;
		}

		return ans;
	}
}
