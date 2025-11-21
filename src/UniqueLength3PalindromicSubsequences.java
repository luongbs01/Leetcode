import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 */

public class UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        int n = s.length(), ans = 0;
        char[] chars = s.toCharArray();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            lists.get(chars[i] - 'a').add(i);
        }
        for (int i = 0; i < 26; i++) {
            List<Integer> list = lists.get(i);
            if (list.size() >= 3) {
                ans++;
            }
            if (list.size() >= 2) {
                for (int j = 0; j < 26; j++) {
                    if (i != j && !lists.get(j).isEmpty() && binarySearch(lists.get(j), list.getFirst(), list.getLast())) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean binarySearch(List<Integer> list, int start, int end) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) > start && list.get(mid) < end) {
                return true;
            } else if (list.get(mid) < start) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return list.get(l) > start && list.get(l) < end;
    }
}
