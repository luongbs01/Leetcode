import java.util.ArrayList;
import java.util.Collections;

/**
 * Description: https://leetcode.com/problems/put-marbles-in-bags/description/
 */
public class PutMarblesInBags {
    public long putMarbles(int[] weights, int k) {
        ArrayList<Integer> weightPair = new ArrayList<>();
        int len = weights.length;
        for (int i = 1; i < len; i++)
            weightPair.add(weights[i - 1] + weights[i]);
        Collections.sort(weightPair);
        len = weightPair.size();
        long ans = 0;
        k--;
        for (int i = 0; i < k; i++) {
            ans += (weightPair.get(len - i - 1) - weightPair.get(i));
        }
        return ans;
    }
}
