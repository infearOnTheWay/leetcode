import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @author infearOnTheWay
 */
public class FindMinArrowShotsSolution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            }
            if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
                if (o1[1] == o2[1]) {
                    return 0;
                }
            }
            return 1;
        });
        int[] cur = points[0];
        int num = 1, idx = 1;
        // 每次都求相交的区间，更新到cur；直到不存在重叠，就用一支箭
        while (idx < points.length) {
            if (points[idx][0] > cur[1]) {
                cur = points[idx];
                num++;
            } else {
                cur[0] = Math.max(cur[0], points[idx][0]);
                cur[1] = Math.min(cur[1], points[idx][1]);
            }
            idx++;
        }
        return num;
    }

}
