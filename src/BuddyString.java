/**
 * Description: https://leetcode.com/problems/buddy-strings/
 */
public class BuddyString {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        boolean isSame = s.compareTo(goal) == 0;
        boolean moreThanOne = false;
        int count = 0;
        int[] occurrence = new int[32];
        char s1 = 'A', s2 = 'B', goal1 = 'C', goal2 = 'D';
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            int index = s.charAt(i) - 'a';
            occurrence[index]++;
            if (occurrence[index] > 1) moreThanOne = true;
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count == 1) {
                    s1 = s.charAt(i);
                    goal1 = goal.charAt(i);
                } else if (count == 2) {
                    s2 = s.charAt(i);
                    goal2 = goal.charAt(i);
                } else return false;
            }
        }
        if ((count == 2) && (s1 == goal2) && (s2 == goal1)) return true;
        return isSame && moreThanOne;
    }
}
