import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 *
 * @author infearOnTheWay
 */
public class MaximumGapSolution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Set<Integer> eles = new HashSet<>();
        for (int elements : nums) {
            max = Math.max(elements, max);
            min = Math.min(elements, min);
            eles.add(elements);
        }
        if (eles.size() < 2) {
            return 0;
        }
        int bucketLength = (max - min) / (eles.size() - 1);
        int bucketNums = (max - min) / bucketLength + 1;
        int[][] bucketMaxMin = new int[bucketNums][2];
        for (int i = 0; i != bucketNums; i++) {
            bucketMaxMin[i][0] = bucketMaxMin[i][1] = -1;
        }
        for (int elements : eles) {
            int bucketIndex = (elements - min) / bucketLength;
            bucketMaxMin[bucketIndex][0] = bucketMaxMin[bucketIndex][0] == -1 ? elements :
                    Math.min(bucketMaxMin[bucketIndex][0], elements);
            bucketMaxMin[bucketIndex][1] = Math.max(bucketMaxMin[bucketIndex][1], elements);
        }
        int result = -1, bucketLeft = -1, bucketIdx = 0;
        while (bucketIdx != bucketNums) {
            if (bucketMaxMin[bucketIdx][0] == -1) {
                bucketIdx++;
                continue;
            }
            if (bucketLeft != -1) {
                result = Math.max(bucketMaxMin[bucketIdx][0] - bucketMaxMin[bucketLeft][1], result);
            }
            bucketLeft = bucketIdx;
            bucketIdx++;
        }
        return result;
    }
}
