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

    public ListNode reverseListV2(ListNode head) {
        ListNode prev = null;
        ListNode ptr = head;

        while (ptr != null) {
            ListNode nextPtr = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nextPtr;
        }
        return prev;
    }
}
