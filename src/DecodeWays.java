/**
 * Description: https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;
        if (n == 1) return 1;
        int[] numberOfWayEndAt = new int[n];
        if (isOneDigitsValid(s.charAt(0)))
            numberOfWayEndAt[0] = 1;
        else return 0;
        if (isOneDigitsValid(s.charAt(1)) && isTwoDigitsValid(s.charAt(0), s.charAt(1)))
            numberOfWayEndAt[1] = 2;
        else if (!isOneDigitsValid(s.charAt(1)) && isTwoDigitsValid(s.charAt(0), s.charAt(1)))
            numberOfWayEndAt[1] = 1;
        else if (isOneDigitsValid(s.charAt(1)) && !isTwoDigitsValid(s.charAt(0), s.charAt(1)))
            numberOfWayEndAt[1] = 1;
        else return 0;
        for (int i = 2; i < n; i++) {
            if (isOneDigitsValid(s.charAt(i)) && isTwoDigitsValid(s.charAt(i - 1), s.charAt(i)))
                numberOfWayEndAt[i] = numberOfWayEndAt[i - 2] + numberOfWayEndAt[i - 1];
            else if (!isOneDigitsValid(s.charAt(i)) && isTwoDigitsValid(s.charAt(i - 1), s.charAt(i)))
                numberOfWayEndAt[i] = numberOfWayEndAt[i - 2];
            else if (isOneDigitsValid(s.charAt(i)) && !isTwoDigitsValid(s.charAt(i - 1), s.charAt(i)))
                numberOfWayEndAt[i] = numberOfWayEndAt[i - 1];
            else return 0;
        }
        return numberOfWayEndAt[n - 1];
    }

    public boolean isOneDigitsValid(char a) {
        return a != '0';
    }

    public boolean isTwoDigitsValid(char a, char b) {
        if (a == 0) return false;
        else if (a == '1') return true;
        else if (a == '2' && b >= '0' && b <= '6') return true;
        else return false;
    }
}
