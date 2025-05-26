import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Node newHead = new Node(0); // dummy node
        Node ptrNew = newHead;
        HashMap<Integer, Integer> random = new HashMap<>();
        HashMap<Integer, Node> newMap = new HashMap<>();
        HashMap<Node, Integer> oldMap = new HashMap<>();
        Node ptr = head;
        int count = 0;
        while (ptr != null) {
            Node node = new Node(ptr.val);
            ptrNew.next = node;
            newMap.put(count, node);
            oldMap.put(ptr, count);
            ptrNew = ptrNew.next;
            ptr = ptr.next;
            count++;
        }
        ptr = head;
        count = 0;
        while (ptr != null) {
            random.put(count, ptr.random != null ? oldMap.get(ptr.random) : -1);
            ptr = ptr.next;
            count++;
        }
        for (int i : random.keySet()) {
            newMap.get(i).random = random.get(i) != -1 ? newMap.get(random.get(i)) : null;
        }
        return newHead.next;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomListV2(Node head) {
        Node newHead = new Node(0); // dummy node
        Node ptrNew = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        Node ptr = head;
        while (ptr != null) {
            Node node = new Node(ptr.val);
            ptrNew.next = node;
            map.put(ptr, node);
            ptrNew = ptrNew.next;
            ptr = ptr.next;
        }
        ptr = head;
        while (ptr != null) {
            map.get(ptr).next = map.get(ptr.next);
            map.get(ptr).random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return newHead.next;
    }
}
