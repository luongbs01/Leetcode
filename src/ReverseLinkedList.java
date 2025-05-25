/**
 * Description: https://leetcode.com/problems/reverse-linked-list/description/
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = head.next;
        head.next = null;
        while (ptr != null) {
            ListNode nextPtr = ptr.next;
            ListNode currHead = head;
            head = ptr;
            head.next = currHead;
            ptr = nextPtr;
        }
        return head;
    }

    // 3 nodes: previous, current, next
    public ListNode reverseListV2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
