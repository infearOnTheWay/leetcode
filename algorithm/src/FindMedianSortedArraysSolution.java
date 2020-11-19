/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/comments/
 *
 * @author infearOnTheWay
 */
public class FindMedianSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int leftMid = (length1 + length2 + 1) / 2, rightMid = (length1 + length2 + 2) / 2;
        // 对于奇偶元素个数的情况统一操作
        return (findKth(nums1, 0, nums2, 0, leftMid) + findKth(nums1, 0, nums2, 0, rightMid)) / 2.0;
    }

    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 如果任何一个数组的元素个数不够k,就直接从另一个数组中寻找
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // 从其中的一个数组中，丢弃较小的k/2个元素
        int mid1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
