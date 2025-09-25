import java.util.List;

/**
 * Description: https://leetcode.com/problems/triangle/
 */

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0)
                    list.set(j, triangle.get(i - 1).get(0) + list.get(0));
                else if (j == list.size() - 1)
                    list.set(j, triangle.get(i - 1).get(list.size() - 2) + list.get(list.size() - 1));
                else
                    list.set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + list.get(j));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, triangle.get(n - 1).get(i));
        }
        return ans;
    }
}
