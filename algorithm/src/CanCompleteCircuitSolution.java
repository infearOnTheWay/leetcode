/**
 * https://leetcode-cn.com/problems/gas-station/
 *
 * @author infearOnTheWay
 */
public class CanCompleteCircuitSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, current = 0, start = 0;
        for (int i = 0; i != gas.length; i++) {
            rest += gas[i] - cost[i];
            current += gas[i] - cost[i];
            // 如果油不够了，说明去往i+1站cost过大，需要把start重新设置到i+1，并重置current=0
            if (current < 0) {
                current = 0;
                start = i + 1;
            }
        }
        // 只要最后的rest能够回复到大于0，就说明油能够补上
        return rest >= 0 ? start : -1;
    }
}
