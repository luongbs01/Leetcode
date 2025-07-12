import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/description/
 */

public class TheEarliestAndLatestRoundsWherePlayersCompete {

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        boolean[] loser = new boolean[n + 1];
        boolean[] possibleRound = new boolean[6];
        Deque<Integer> deque = new ArrayDeque<>(n);
        backtrack(n, deque, loser, firstPlayer, secondPlayer, 0, possibleRound);
        int[] ans = new int[2];
        for (int i = 1; i < 6; i++) {
            if (possibleRound[i]) {
                ans[0] = i;
                break;
            }
        }
        for (int i = 5; i > 0; i--) {
            if (possibleRound[i]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    private void backtrack(int n, Deque<Integer> deque, boolean[] loser, int firstPlayer, int secondPlayer, int round, boolean[] possibleRound) {
        if (deque.size() > 1) {
            int player1 = deque.pollFirst();
            int player2 = deque.pollLast();
            if (player1 == firstPlayer && player2 == secondPlayer) {
                possibleRound[round] = true;
            } else if (player1 == firstPlayer || player1 == secondPlayer) {
                loser[player2] = true;
                backtrack(n, deque, loser, firstPlayer, secondPlayer, round, possibleRound);
                loser[player2] = false;
            } else if (player2 == firstPlayer || player2 == secondPlayer) {
                loser[player1] = true;
                backtrack(n, deque, loser, firstPlayer, secondPlayer, round, possibleRound);
                loser[player1] = false;
            } else {
                for (int i = 1; i <= 2; i++) {
                    loser[player1] = i == 1;
                    loser[player2] = i == 2;
                    backtrack(n, deque, loser, firstPlayer, secondPlayer, round, possibleRound);
                    loser[player1] = false;
                    loser[player2] = false;
                }
            }
            deque.offerFirst(player1);
            deque.offerLast(player2);
        } else {
            // MUST use a new queue
            Deque<Integer> nextRound = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (!loser[i]) {
                    nextRound.offer(i);
                }
            }
            backtrack(n, nextRound, loser, firstPlayer, secondPlayer, round + 1, possibleRound);
        }
    }
}
