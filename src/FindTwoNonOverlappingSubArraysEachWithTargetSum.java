import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 */

public class FindTwoNonOverlappingSubArraysEachWithTargetSum {

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, sum = 0, ans = Integer.MAX_VALUE;
        List<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            Integer lastIdx = lastIndex.get(sum - target);
            if (lastIdx != null) {
                list.add(new int[] { lastIdx + 1, i, i - lastIdx });
            }
            lastIndex.put(sum, i);
        }

        n = list.size();
        if (n < 2)
            return -1;
        int[] prefixMin = new int[n];
        prefixMin[0] = list.getFirst()[2];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], list.get(i)[2]);
        }
        for (int i = 1; i < n; i++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (list.get(mid)[1] < list.get(i)[0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (list.get(l)[1] < list.get(i)[0]) {
                ans = Math.min(ans, list.get(i)[2] + prefixMin[l]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
