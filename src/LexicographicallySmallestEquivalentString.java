/**
 * Description: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 */

public class LexicographicallySmallestEquivalentString {

    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int n = chars1.length;
        for (int i = 1; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            union(chars1[i], chars2[i]);
        }
        char[] chars = baseStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (find(chars[i]) + 'a');
        }
        return new String(chars);
    }

    private int find(char c) {
        if (c - 'a' == parent[c - 'a']) {
            return c - 'a';
        }
        int par = find((char) (parent[c - 'a'] + 'a'));
        parent[c - 'a'] = par;
        return par;
    }

    private void union(char c1, char c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 < p2) {
            parent[p2] = p1;
        } else if (p1 > p2) {
            parent[p1] = p2;
        }
    }
}
