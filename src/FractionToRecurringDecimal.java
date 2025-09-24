import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            ans.append('-');
        long num = numerator;
        num = Math.abs(num);
        long den = denominator;
        den = Math.abs(den);
        ans.append(num / den);
        long i = num % den;
        if (i == 0)
            return ans.toString();
        ans.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (i != 0 && ans.length() < 10000) {
            i *= 10;
            if (map.containsKey(i)) {
                ans.insert(map.get(i), "(");
                ans.append(')');
                return ans.toString();
            }
            map.put(i, ans.length());
            ans.append(i / den);
            i %= den;
        }
        return ans.toString();
    }
}
