/**
 * Description: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list2.val < list1.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode ptr1 = list1, ptr2 = list2;
        while (ptr2 != null) {
            if (ptr1.next == null) {
                ptr1.next = ptr2;
                return list1;
            }
            while (ptr1.next != null && ptr1.next.val < ptr2.val) {
                ptr1 = ptr1.next;
            }
            // merge list2's node after list1's current node
            ListNode temp = ptr2.next;
            ptr2.next = ptr1.next;
            ptr1.next = ptr2;
            ptr2 = temp;
        }
        return list1;
    }
}
