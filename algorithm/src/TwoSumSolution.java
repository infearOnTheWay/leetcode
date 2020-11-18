import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author infearOnTheWay
 */
public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> value2Idx = new HashMap();
        for (int i = 0; i != nums.length; i++) {
            value2Idx.putIfAbsent(nums[i], new LinkedList<>());
            value2Idx.get(nums[i]).add(i);
        }
        for (Integer first : value2Idx.keySet()) {
            int second = target - first;
            if (second == first) {
                if (value2Idx.get(first).size() == 2) {
                    return new int[] {value2Idx.get(first).get(0), value2Idx.get(first).get(1)};
                }
            } else {
                if (value2Idx.containsKey(second)) {
                    return new int[] {value2Idx.get(first).get(0), value2Idx.get(second).get(0)};
                }
            }
        }
        return null;
    }
}
