import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/brace-expansion-ii/
 */

public class BraceExpansionII {

    // Idea from https://leetcode.com/problems/brace-expansion-ii/solutions/8538930/trust-me-its-not-hard-master-dfs-with-di-73mt
    public List<String> braceExpansionII(String expression) {
        TreeSet<String> ans = new TreeSet<>();
        dfs(ans, expression);
        return new ArrayList<>(ans);
    }

    void dfs(TreeSet<String> ans, String expression) {
        int fistClosing = expression.indexOf('}');
        if (fistClosing < 0) {
            ans.add(expression);
            return;
        }
        int opening = fistClosing - 1;
        while (opening >= 0 && expression.charAt(opening) != '{') {
            opening--;
        }
        String[] strings = expression.substring(opening + 1, fistClosing).split(",");
        for (String str : strings) {
            dfs(ans, expression.substring(0, opening) + str + expression.substring(fistClosing + 1));
        }
    }
}
