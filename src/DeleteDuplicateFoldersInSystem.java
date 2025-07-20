import java.util.*;

/**
 * Description: https://leetcode.com/problems/delete-duplicate-folders-in-system/description/
 */

public class DeleteDuplicateFoldersInSystem {

    Map<String, Integer> hashCount;
    List<List<String>> ans;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        hashCount = new HashMap<>();
        Trie trie = new Trie("");
        for (List<String> path : paths) {
            trie.add(path);
        }
        dfs(trie);
        ans = new ArrayList<>();
        backtrack(trie, new ArrayList<>());
        return ans;
    }

    private void backtrack(Trie trie, List<String> currPath) {
        if (hashCount.getOrDefault(trie.hash, 0) < 2) {
            if (!currPath.isEmpty()) {
                ans.add(new ArrayList<>(currPath));
            }
            for (String key : trie.children.keySet()) {
                currPath.add(key);
                backtrack(trie.children.get(key), currPath);
                currPath.remove(currPath.size() - 1);
            }
        }
    }

    private String dfs(Trie trie) {
        if (trie.children.isEmpty()) {
            trie.hash = "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String key : trie.children.keySet()) {
                sb.append(trie.children.get(key).val).append("(").append(dfs(trie.children.get(key))).append(")");
            }
            trie.hash = sb.toString();
            hashCount.put(trie.hash, hashCount.getOrDefault(trie.hash, 0) + 1);
        }
        return trie.hash;
    }

    private static class Trie {
        Map<String, Trie> children;
        String hash;
        String val;

        public Trie(String val) {
            children = new TreeMap<>();
            this.val = val;
        }

        public void add(List<String> path) {
            int i = 0;
            Map<String, Trie> curr = children;
            while (i < path.size() && curr.containsKey(path.get(i))) {
                curr = curr.get(path.get(i)).children;
                i++;
            }
            while (i < path.size()) {
                curr.put(path.get(i), new Trie(path.get(i)));
                curr = curr.get(path.get(i)).children;
                i++;
            }
        }
    }
}
