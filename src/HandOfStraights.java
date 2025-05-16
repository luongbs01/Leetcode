import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/hand-of-straights/
 */

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : hand) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < hand.length / groupSize; i++) {
            int firstMember = treeMap.firstKey();
            for (int j = 0; j < groupSize; j++) {
                if (treeMap.containsKey(firstMember + j)) {
                    int val = treeMap.get(firstMember + j);
                    if (val > 1) {
                        treeMap.put(firstMember + j, val - 1);
                    } else {
                        treeMap.remove(firstMember + j);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
