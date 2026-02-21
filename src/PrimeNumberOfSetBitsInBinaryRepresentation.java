import java.util.Set;

/**
 * Description: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */

public class PrimeNumberOfSetBitsInBinaryRepresentation {

	public int countPrimeSetBits(int left, int right) {
		Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
		int ans = 0;
		for (int i = left; i <= right; i++) {
			if (primes.contains(Integer.bitCount(i))) {
				ans++;
			}
		}
		return ans;
	}
}
