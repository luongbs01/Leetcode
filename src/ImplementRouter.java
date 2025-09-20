import java.util.*;

/**
 * Description: https://leetcode.com/problems/implement-router/
 */

public class ImplementRouter {

    class Router {

        Queue<int[]> queue;
        Set<List<Integer>> set = new HashSet<>();
        int memoryLimit;
        Map<Integer, List<Integer>> destToTimeStamp = new HashMap<>();
        Map<Integer, Integer> forwardedPacketIndex = new HashMap<>();

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            queue = new ArrayDeque<>(memoryLimit);
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            List<Integer> packet = List.of(source, destination, timestamp);
            if (set.contains(packet)) return false;
            if (queue.size() == memoryLimit) forwardPacket();
            queue.offer(new int[]{source, destination, timestamp});
            set.add(packet);
            destToTimeStamp.putIfAbsent(destination, new ArrayList<>());
            destToTimeStamp.get(destination).add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (queue.isEmpty())
                return new int[0];
            int[] packet = queue.poll();
            set.remove(List.of(packet[0], packet[1], packet[2]));
            forwardedPacketIndex.put(packet[1], forwardedPacketIndex.getOrDefault(packet[1], 0) + 1);
            return packet;
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> list = destToTimeStamp.get(destination);
            if (list == null || list.get(0) > endTime || list.get(list.size() - 1) < startTime) return 0;
            int startIndex, endIndex, l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (list.get(mid) < startTime) l = mid + 1;
                else r = mid;
            }
            startIndex = Math.max(l, forwardedPacketIndex.getOrDefault(destination, 0));
            l = 0;
            r = list.size() - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (list.get(mid) > endTime) r = mid - 1;
                else l = mid;
            }
            endIndex = r;
            return Math.max(endIndex - startIndex + 1, 0);
        }
    }
}
