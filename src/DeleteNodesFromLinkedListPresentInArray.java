/**
 * Description: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
 */

public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] arr = new boolean[100001];
        for (int i : nums) {
            arr[i] = true;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, ptr = dummy;
        while (ptr.next != null) {
            if (!arr[ptr.next.val]) {
                prev.next = ptr.next;
                prev = prev.next;
            }
            ptr = ptr.next;
        }
        prev.next = null;
        return dummy.next;
    }
}
