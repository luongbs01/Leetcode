import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/partition-labels/description/
 */

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) {
            return List.of(1);
        }
        int[][] intervals = new int[26][2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < 26; i++) {
            Arrays.fill(intervals[i], -1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (intervals[chars[i] - 'a'][1] == -1) {
                intervals[chars[i] - 'a'][0] = i;
            }
            intervals[chars[i] - 'a'][1] = i;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < 26; i++) {
            if (merged.getLast()[1] >= intervals[i][0]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
            } else {
                merged.addLast(intervals[i]);
            }
        }
        List<Integer> ans = new LinkedList<>();
        if (merged.getFirst()[1] == -1) {
            merged.removeFirst();
        }
        for (int[] i : merged) {
            ans.add(i[1] - i[0] + 1);
            System.out.println("(" + i[0] + ", " + i[1] + ")   ");
        }
        return ans;
    }
}
