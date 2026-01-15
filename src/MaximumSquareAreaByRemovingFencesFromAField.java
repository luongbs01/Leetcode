import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
 */

public class MaximumSquareAreaByRemovingFencesFromAField {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> hSet = distance(m, hFences);
        Set<Integer> vSet = distance(n, vFences);
        int max = -1;
        for (int i : hSet) {
            if (vSet.contains(i) && i > max) {
                max = i;
            }
        }
        return max > 0 ? (int) ((long) max * max % 1_000_000_007) : -1;
    }

    private Set<Integer> distance(int m, int[] fences) {
        int[] arr = new int[fences.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = m;
        if (arr.length - 2 > 0) System.arraycopy(fences, 0, arr, 1, arr.length - 2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                set.add(arr[j] - arr[i]);
            }
        }
        return set;
    }
}
