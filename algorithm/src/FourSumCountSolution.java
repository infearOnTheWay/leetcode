import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 *
 * @author infearOnTheWay
 */
public class FourSumCountSolution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumOfAB = new HashMap<>();
        Map<Integer, Integer> sumOfCD = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                sumOfAB.put(a + b, sumOfAB.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                sumOfCD.put(c + d, sumOfCD.getOrDefault(c + d, 0) + 1);
            }
        }
        int count = 0;
        for (Integer part : sumOfAB.keySet()) {
            count += sumOfAB.get(part) * sumOfCD.getOrDefault(-part, 0);
        }
        return count;
    }
}
