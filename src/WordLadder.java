import java.util.*;

/**
 * Description: https://leetcode.com/problems/word-ladder/
 */

public class WordLadder {

    Set<String> set = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set.addAll(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        return bfs(beginWord, endWord);
    }

    private int bfs(String beginWord, String endWord) {
        Queue<String> queue = new ArrayDeque<>();
        int count = 1;
        queue.offer(beginWord);
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (int j = 0; j < s.length(); j++) {
                    char[] chars = s.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String word = new String(chars);
                        if (set.contains(word)) {
                            if (word.equals(endWord)) {
                                return count;
                            }
                            set.remove(word);
                            queue.offer(word);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
