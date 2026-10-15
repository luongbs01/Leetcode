/**
 * Description: https://leetcode.com/problems/count-days-spent-together/
 */

public class CountDaysSpentTogether {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String arrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String leave = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        return Math.max(0, count(leave, days) - count(arrive, days) + 1);
    }

    private int count(String date, int[] days) {
        int cnt = 0;
        String[] split = date.split("-");
        int m = Integer.parseInt(split[0]);
        int d = Integer.parseInt(split[1]);
        for (int i = 0; i < m - 1; i++) {
            cnt += days[i];
        }
        return cnt + d;
    }
}
