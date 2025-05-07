/**
 * Description: https://leetcode.com/problems/linked-list-cycle/description/
 */

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleV2(ListNode head) {
        ListNode slow = head, fast = head;
        // if fast != null, then slow != null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

//    If a cycle exists, the fast pointer moves faster and continuously loops through the cycle.
//    With each step, it reduces the gap between itself and the slow pointer by one node.
//    For example, if the gap is 10, the slow pointer moves by 1, increasing the gap to 11,
//    while the fast pointer moves by 2, reducing the gap to 9.
//    This process continues until the fast pointer catches up to the slow pointer, confirming a cycle.
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
