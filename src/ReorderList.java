import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: https://leetcode.com/problems/reorder-list/description/
 */

public class ReorderList {

    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode tail = null;
        while (!stack.isEmpty()) {
            System.out.println(stack);
            tail = stack.pop();
            ListNode next = head.next;
            tail.next = next;
            head.next = tail;
            head = next;
        }
        if (head == tail) {
            head.next = null;
        } else {
            tail.next = null;
        }
    }
}
