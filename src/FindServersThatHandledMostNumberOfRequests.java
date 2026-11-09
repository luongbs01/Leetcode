import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/description/
 */

public class FindServersThatHandledMostNumberOfRequests {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] processed = new int[k];
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        TreeSet<Integer> freeServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            freeServers.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!busyServers.isEmpty() && busyServers.peek()[1] <= arrival[i]) {
                freeServers.add(busyServers.poll()[0]);
            }
            if (freeServers.isEmpty()) {
                continue;
            }
            Integer chosen = freeServers.ceiling(i % k);
            if (chosen == null) {
                chosen = freeServers.first();
            }
            processed[chosen]++;
            freeServers.remove(chosen);
            busyServers.offer(new int[]{chosen, arrival[i] + load[i]});
        }

        int max = 0;
        for (int i : processed) {
            max = Math.max(max, i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (processed[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}
