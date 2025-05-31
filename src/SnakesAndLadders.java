import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/snakes-and-ladders/description/
 */

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];
        int count = 1;
        int i = n - 1;
        while (count <= n * n) {
            for (int j = 0; j < n; j++) {
                arr[count] = board[i][j];
                count++;
            }
            i--;
            for (int j = n - 1; i >= 0 && j >= 0; j--) {
                arr[count] = board[i][j];
                count++;
            }
            i--;
        }
        count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (queue.size() <= n * n * n) {
            int size = queue.size();
            count++;
            for (int j = 0; j < size; j++) {
                int k = queue.poll();
                if (k + 6 >= n * n) {
                    return count;
                }
                int m = 0;
                for (int l = 1; l <= 6; l++) {
                    if (arr[k + l] != -1) {
                        if (arr[k + l] == n * n) {
                            return count;
                        }
                        queue.offer(arr[k + l]);
                    } else {
                        m = l;
                    }
                }
                if (arr[k + m] != -1) {
                    if (arr[k + m] == n * n) {
                        return count;
                    }
                    queue.offer(arr[k + m]);
                } else if (arr[k + m] == -1) {
                    queue.offer(k + m);
                }
            }
        }
        return -1;
    }
}
