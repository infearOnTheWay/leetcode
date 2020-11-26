/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author infearOnTheWay
 */
public class ReverseSolution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        boolean negative = false;
        long pow = 1, result = 0;
        for (char c : str.toCharArray()) {
            if (c == '-') {
                negative = true;
            } else {
                result = result + (c - '0') * pow;
                pow *= 10;
            }
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result * (negative ? -1 : 1);

    }
}
