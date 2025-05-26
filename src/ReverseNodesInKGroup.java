/**
 * Description: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode beforeFirst = dummy;
        ListNode last = dummy;
        int count = 0;
        while (count < k && last != null) {
            last = last.next;
            count++;
        }
        while (last != null) {
            if (count == k) {
                ListNode first = beforeFirst.next;
                ListNode afterLast = last.next;
                reverseList(first, last);
                beforeFirst.next = last;
                first.next = afterLast;
                beforeFirst = first;
                last = first;
                count = 0;
            }
            last = last.next;
            count++;
        }
        return dummy.next;
    }

    private void reverseList(ListNode head, ListNode tail) {
        ListNode afterTail = tail.next;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && curr != afterTail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
