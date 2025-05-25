import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/find-the-duplicate-number/description/
 */

public class LRUCache {
    HashMap<Integer, int[]> hashMap; // value[0] : value, value[1]: frequency of value in queue
    Deque<Integer> lru;
    int capacity;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<>(capacity);
        this.lru = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            int[] value = hashMap.get(key);
            lru.offer(key);
            hashMap.put(key, new int[]{value[0], value[1] + 1});
            return value[0];
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            hashMap.put(key, new int[]{value, hashMap.get(key)[1] + 1});
        } else {
            while (hashMap.size() == capacity) {
                int k = lru.poll();
                int[] v = hashMap.get(k);
                if (v[1] > 1) {
                    hashMap.put(k, new int[]{v[0], v[1] - 1});
                } else {
                    hashMap.remove(k);
                }
            }
            hashMap.put(key, new int[]{value, 1});
        }
        lru.offer(key);
    }
}
