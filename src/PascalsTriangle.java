import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/pascals-triangle/description/
 */

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(List.of(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            for (int j = 1; j <= i - 2; j++) {
                list.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
