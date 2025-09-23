/**
 * Description: https://leetcode.com/problems/compare-version-numbers/description/
 */


public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        int n = Math.max(revisions1.length, revisions2.length);
        for (int i = 0; i < n; i++) {
            int revision1 = i < revisions1.length ? Integer.parseInt(revisions1[i]) : 0;
            int revision2 = i < revisions2.length ? Integer.parseInt(revisions2[i]) : 0;
            if (revision1 < revision2)
                return -1;
            if (revision1 > revision2)
                return 1;
        }

    }
}
