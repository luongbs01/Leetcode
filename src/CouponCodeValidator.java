import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/coupon-code-validator/
 */

public class CouponCodeValidator {

    Set<String> businesses = Set.of("electronics", "grocery", "pharmacy", "restaurant");

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<List<String>> coupons = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (isActive[i] && isValidCode(code[i]) && businesses.contains(businessLine[i])) {
                coupons.add(List.of(code[i], businessLine[i]));
            }
        }
        coupons.sort((o1, o2) -> o1.get(1).equals(o2.get(1)) ? o1.get(0).compareTo(o2.get(0)) : o1.get(1).compareTo(o2.get(1)));
        List<String> ans = new ArrayList<>(coupons.size());
        for (List<String> coupon : coupons) {
            ans.add(coupon.get(0));
        }
        return ans;
    }

    private boolean isValidCode(String code) {
        if (code.isBlank()) return false;
        char[] chars = code.toCharArray();
        for (char c : chars) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
}
