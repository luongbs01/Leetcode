import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/
 */

public class MinimumSwapsToSortByDigitSum {

    public int minSwaps(int[] nums) {
        int n = nums.length, ans = 0;
        boolean[] visited = new boolean[n];
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i, sumDigits(nums[i])};
        }
        Arrays.sort(arr, (o1, o2) -> o1[2] == o2[2] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < n; i++) {
            if (nums[i] != arr[i][1] && !visited[i]) {
                int cnt = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j][1];
                    cnt++;
                }
                ans += (cnt - 1);
            }
        }
        return ans;
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
