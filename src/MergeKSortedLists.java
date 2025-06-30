import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/merge-k-sorted-lists/description/
 */

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        ListNode ptr = ans;
        PriorityQueue<Map.Entry<Integer, ListNode>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(Map.entry(node.val, node));
            }
        }
        while (!pq.isEmpty()) {
            Map.Entry<Integer, ListNode> e = pq.poll();
            ptr.next = new ListNode(e.getKey());
            ptr = ptr.next;
            if (e.getValue().next != null) {
                pq.offer(Map.entry(e.getValue().next.val, e.getValue().next));
            }
        }
        return ans.next;
    }
}
