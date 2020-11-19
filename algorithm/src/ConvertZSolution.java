import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author infearOnTheWay
 */
public class ConvertZSolution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> result = new ArrayList();
        for (int i = 0; i != Math.min(numRows, s.length()); i++) {
            result.add(new StringBuilder());
        }
        int cur = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            result.get(cur).append(c);
            if (cur == 0 || cur == numRows - 1) {
                down = !down;
            }
            cur += down ? 1 : -1;
        }
        StringBuilder total = new StringBuilder();
        result.forEach(row -> total.append(row));
        return total.toString();
    }
}
