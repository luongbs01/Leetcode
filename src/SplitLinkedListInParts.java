/**
 * Description: https://leetcode.com/problems/split-linked-list-in-parts/description/
 */

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ptr = head;
        int n = 0;
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }
        int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = n / k;
            n -= n / k;
            k--;
        }
        ListNode[] ans = new ListNode[arr.length];
        ListNode first = head;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = first;
            for (int j = 0; j < arr[i] - 1; j++) {
                first = first.next;
            }
            if (first != null) {
                ListNode next = first.next;
                first.next = null;
                first = next;
            }
        }
        return ans;
    }
}
