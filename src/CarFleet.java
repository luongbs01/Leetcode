import java.util.*;

/**
 * Description: https://leetcode.com/problems/car-fleet/
 */

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{position[length - 1], map.get(position[length - 1]), 1});
        for (int i = length - 2; i >= 0; i--) {
            int[] fleet = deque.peek();
            if (map.get(position[i]) <= fleet[1]) {
                deque.push(new int[]{position[i], map.get(position[i]), 1});
            } else {
                double timeToCatchup = (double) (fleet[0] - position[i]) / (map.get(position[i]) - fleet[1]);
                double timeToTarget = (double) (target - fleet[0]) / fleet[1];
                if (timeToCatchup <= timeToTarget) { // form a fleet
                    deque.pop();
                    deque.push(new int[]{fleet[0], fleet[1], fleet[2] + 1});
                } else {
                    deque.push(new int[]{position[i], map.get(position[i]), 1});
                }
            }
        }
        return deque.size();
    }
}
