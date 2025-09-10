/**
 * Description: https://leetcode.com/problems/minimum-number-of-people-to-teach/description/
 */

public class MinimumNumberOfPeopleToTeach {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length, countPeople = 0, countLanguage = 0;
        int[] count = new int[n + 1];
        boolean[] people = new boolean[m + 1];
        for (int[] friendship : friendships) {
            boolean[] language = new boolean[n + 1];
            boolean canCommunicate = false;
            for (int i : languages[friendship[0] - 1]) {
                language[i] = true;
            }
            for (int i : languages[friendship[1] - 1]) {
                if (language[i]) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                people[friendship[0]] = true;
                people[friendship[1]] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            if (people[i]) {
                countPeople++;
                for (int j : languages[i - 1]) {
                    count[j]++;
                    countLanguage = Math.max(countLanguage, count[j]);
                }
            }
        }
        return countPeople - countLanguage;
    }
}
