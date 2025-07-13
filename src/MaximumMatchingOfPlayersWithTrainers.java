import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/
 */

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int player = 0, trainer = 0;
        int ans = 0;
        while (player < players.length && trainer < trainers.length) {
            if (players[player] <= trainers[trainer]) {
                player++;
                ans++;
            }
            trainer++;
        }
        return ans;
    }
}
