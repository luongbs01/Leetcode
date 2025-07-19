import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
 */

public class RemoveSubFoldersFromTheFilesystem {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String string : folder) {
            if (stack.isEmpty() || !string.startsWith(stack.peek() + "/")) {
                stack.push(string);
            }
        }
        List<String> ans = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    public List<String> removeSubfoldersV2(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        for (String string : folder) {
            if (ans.isEmpty() || !string.startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(string);
            }
        }
        return ans;
    }
}
