import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/lexicographical-numbers/description/
 */

public class LexicographicalNumbers {

    List<Integer> ans;

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            gen(i, n);
        }
        return ans;
    }

    private void gen(int i, int n) {
        if (i <= n) {
            ans.add(i);
            for (int j = 0; j < 10; j++) {
                gen(i * 10 + j, n);
            }
        }
    }
}
