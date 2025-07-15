/**
 * Description: https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
 */

public class NumberOfEmployeesWhoMetTheTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            ans += hour >= target ? 1 : 0;
        }
        return ans;
    }
}
