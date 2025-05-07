/**
 * Description: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null) { // n equals to the number of nodes
            return head.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
