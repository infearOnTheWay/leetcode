/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author infearOnTheWay
 */
public class MoveZeroesSolution {
    public void moveZeroes(int[] nums) {
        int zeroPos = 0;
        for (int i = 0; i != nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroPos] = nums[i];
                // 只有在需要移动时才需要nums[i]置为0
                if (zeroPos != i) {
                    nums[i] = 0;
                }
                zeroPos++;
            }
        }
    }
}
