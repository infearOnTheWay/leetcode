
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author infearOnTheWay
 * <p>
 * https://leetcode-cn.com/problems/freedom-trail/
 */
public class FindRotateStepsSolution {
    public int findRotateSteps(String ring, String key) {
        // 找到每个key的字符在ring中的idx列表
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        char[] keyArr = key.toCharArray(), ringArr = ring.toCharArray();
        for (int idx = 0; idx != ringArr.length; idx++) {
            charPositions.putIfAbsent(ringArr[idx], new LinkedList<>());
            charPositions.get(ringArr[idx]).add(idx);
        }
        // 使用动态规划
        int result[][] = new int[ringArr.length][keyArr.length + 1];
        for (int keyIdx = keyArr.length; keyIdx >= 0; keyIdx--) {
            for (int ringIdx = 0; ringIdx != ringArr.length; ringIdx++) {
                if (keyIdx == keyArr.length) {
                    result[ringIdx][keyIdx] = 0;
                } else {
                    if (ringArr[ringIdx] == keyArr[keyIdx]) {
                        result[ringIdx][keyIdx] = result[ringIdx][keyIdx + 1] + 1;
                    } else {
                        result[ringIdx][keyIdx] = Integer.MAX_VALUE;
                        for (int idx : charPositions.get(keyArr[keyIdx])) {
                            // 距离的计算要注意有顺逆时针两种情况，在其中取较小的
                            int distance;
                            if (ringIdx <= idx) {
                                distance = Math.min(idx - ringIdx, ringIdx + ringArr.length - idx);
                            } else {
                                distance = Math.min(ringIdx - idx, idx + ringArr.length - ringIdx);
                            }
                            result[ringIdx][keyIdx] = Math.min(result[ringIdx][keyIdx],
                                    result[idx][keyIdx + 1] + 1 + distance);
                        }
                    }
                }
                System.out.println(String.format("result[%d][%d]:%d", ringIdx, keyIdx, result[ringIdx][keyIdx]));
            }
        }
        return result[0][0];
    }

    public static void main(String args[]) {
        new FindRotateStepsSolution().findRotateSteps("abcde", "ade");
    }
}
