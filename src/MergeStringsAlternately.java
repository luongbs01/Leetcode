/**
 * Description: https://leetcode.com/problems/merge-strings-alternatelydd
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        while (i < len1) {
            res.append(word1.charAt(i++));
        }
        while (j < len2) {
            res.append(word2.charAt(j++));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately m = new MergeStringsAlternately();
        System.out.println(m.mergeAlternately("abcde", "efg"));
    }
}
