import java.util.*;

/**
 * Description: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/
 */

public class FindXSumOfAllKLongSubarraysII {

    TreeSet<List<Long>> treeSet1, treeSet2;
    long sum = 0;
    int x;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        this.x = x;
        long[] ans = new long[n - k + 1];
        treeSet1 = new TreeSet<>((o1, o2) -> Math.toIntExact(Objects.equals(o1.getFirst(), o2.getFirst()) ? o1.get(1) - o2.get(1) : o1.getFirst() - o2.getFirst()));
        treeSet2 = new TreeSet<>((o1, o2) -> Math.toIntExact(Objects.equals(o1.getFirst(), o2.getFirst()) ? o1.get(1) - o2.get(1) : o1.getFirst() - o2.getFirst()));
        HashMap<Long, Long> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put((long) nums[i], freq.getOrDefault((long) nums[i], 0L) + 1);
        }
        for (Map.Entry<Long, Long> entry : freq.entrySet()) {
            treeSet2.add(List.of(entry.getValue(), entry.getKey()));
        }
        ans[0] = get();
        for (int i = 0; i < ans.length - 1; i++) {
            Long left = freq.getOrDefault((long) nums[i], 0L);
            if (treeSet1.contains(List.of(left, (long) nums[i]))) {
                treeSet1.remove(List.of(left, (long) nums[i]));
                sum -= nums[i];
                if (left > 1) {
                    treeSet1.add(List.of(left - 1, (long) nums[i]));
                }
            } else if (treeSet2.contains(List.of(left, (long) nums[i]))) {
                treeSet2.remove(List.of(left, (long) nums[i]));
                if (left > 1) {
                    treeSet2.add(List.of(left - 1, (long) nums[i]));
                }
            }
            freq.put((long) nums[i], left - 1);

            Long right = freq.getOrDefault((long) nums[i + k], 0L);
            if (treeSet1.contains(List.of(right, (long) nums[i + k]))) {
                treeSet1.remove(List.of(right, (long) nums[i + k]));
                sum += nums[i + k];
                treeSet1.add(List.of(right + 1, (long) nums[i + k]));
            } else if (treeSet2.contains(List.of(right, (long) nums[i + k]))) {
                treeSet2.remove(List.of(right, (long) nums[i + k]));
                treeSet2.add(List.of(right + 1, (long) nums[i + k]));
            } else {
                treeSet2.add(List.of(right + 1, (long) nums[i + k]));
            }
            freq.put((long) nums[i + k], right + 1);

            ans[i + 1] = get();
        }
        return ans;
    }

    private long get() {
        while (treeSet1.size() < x && !treeSet2.isEmpty()) {
            List<Long> list = treeSet2.pollLast();
            sum += list.get(0) * list.get(1);
            treeSet1.add(list);
        }
        if (!treeSet2.isEmpty() && (treeSet1.getFirst().getFirst() < treeSet2.getLast().getFirst()
                || (treeSet1.getFirst().getFirst() == treeSet2.getLast().getFirst() && treeSet1.getFirst().get(1) < treeSet2.getLast().get(1)))) {
            List<Long> list1 = treeSet1.pollFirst();
            sum -= list1.get(0) * list1.get(1);
            treeSet2.add(list1);
            List<Long> list2 = treeSet2.pollLast();
            sum += list2.get(0) * list2.get(1);
            treeSet1.add(list2);
        }
        return sum;
    }
}
