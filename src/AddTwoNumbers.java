/**
 * Description: https://leetcode.com/problems/add-two-numbers/description/
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode ans = new ListNode(), ptr = ans;
        int sum, r = 0;
        int val1, val2;
        while (ptr1 != null || ptr2 != null) {
            val1 = ptr1 != null ? ptr1.val : 0;
            val2 = ptr2 != null ? ptr2.val : 0;
            sum = val1 + val2 + r;
            r = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            ptr1 = ptr1 != null ? ptr1.next : null;
            ptr2 = ptr2 != null ? ptr2.next : null;
        }
        if (r != 0) {
            ptr.next = new ListNode(r);
        }
        return ans.next;
    }
}
