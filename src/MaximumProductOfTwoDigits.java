import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximum-product-of-two-digits/
 */

public class MaximumProductOfTwoDigits {

	public int maxProduct(int n) {
		List<Integer> arr = new ArrayList<>();
		while (n > 0) {
			arr.add(n % 10);
			n /= 10;
		}
		Collections.sort(arr);
		n = arr.size() - 1;
		return arr.get(n - 1) * arr.get(n);
	}
}
