import java.util.*;

/**
 * Description: https://leetcode.com/problems/word-search-ii/
 */

public class WordSearchII {

    List<String> ans;
    int m, n;
    boolean[][] marked;
    Trie trie;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    char[][] board;
    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        this.board = board;
        m = board.length;
        n = board[0].length;
        ans = new LinkedList<>();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                marked = new boolean[m][n];
                marked[i][j] = true;
                backtrack(i, j, marked, trie, new StringBuilder().append(board[i][j]));
            }
        }
        return ans;
    }

    private void backtrack(int i, int j, boolean[][] marked, Trie node, StringBuilder word) {
        if (node.children.containsKey(board[i][j])) {
            if (node.children.get(board[i][j]).isWord) {
                String str = word.toString();
                if (!set.contains(str)) {
                    ans.add(str);
                    set.add(str);
                }
            }
            for (int[] direction : directions) {
                int nextX = i + direction[0];
                int nextY = j + direction[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !marked[nextX][nextY] && node.children.get(board[i][j]).children.containsKey(board[nextX][nextY])) {
                    marked[nextX][nextY] = true;
                    word.append(board[nextX][nextY]);
                    backtrack(nextX, nextY, marked, node.children.get(board[i][j]), word);
                    marked[nextX][nextY] = false;
                    word.deleteCharAt(word.length() - 1);
                }
            }
        }
    }

    class Trie {
        boolean isWord;
        Map<Character, Trie> children;

        public Trie() {
            isWord = false;
            children = new HashMap<>();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie node = this;
            for (char c : chars) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }
    }
}
