/**
 * Description: https://leetcode.com/problems/rotate-list/description/
 */

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        if (cnt < 2 || k % cnt == 0) {
            return head;
        }
        k = k % cnt;
        ptr = head;
        for (int i = 1; i < cnt - k; i++) {
            ptr = ptr.next;
        }
        ListNode newHead = ptr.next;
        ptr.next = null;
        ptr = newHead;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = head;
        return newHead;
    }
}
