import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/happy-number/description/
 */

public class HappyNumber {

    public boolean isHappy(int n) {
        int sum = 0;
        int count = 0;
        while (sum != 1 && count < 20) {
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            count++;
        }
        return count < 20;
    }

    public boolean isHappyV2(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (sum != 1 && !set.contains(n)) {
            set.add(n);
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return sum == 1;
    }
}
