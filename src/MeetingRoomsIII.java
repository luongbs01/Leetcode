import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/meeting-rooms-iii/description/
 */

public class MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int[] cnt = new int[n];
        long[] endTime = new long[n]; // endTime of room i, 0 <= i < n
        for (int[] meeting : meetings) {
            // neu thoi gian bat dau < thoi gian ket thuc cua moi room
            // => chon room ket thuc som nhat
            // neu thoi gian bat dau >= thoi gian ket thuc cua mot so room
            // => chon room nho nhat
            long minEndTime = endTime[0];
            int index = 0;
            int room = -1;
            for (int i = 0; i < n; i++) {
                if (meeting[0] >= endTime[i]) {
                    room = i;
                    break;
                }
                if (minEndTime > endTime[i]) {
                    minEndTime = endTime[i];
                    index = i;
                }
            }
            if (room == -1) {
                cnt[index]++;
                endTime[index] = endTime[index] + meeting[1] - meeting[0];
            } else {
                cnt[room]++;
                endTime[room] = meeting[1];
            }
        }
        int ans = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                ans = i;
            }
        }
        return ans;
    }
}
