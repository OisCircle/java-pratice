package algorithm.leetcode.array;

/**
 *
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * 思路：先第一遍找最大值，第二遍挨个比较
 *
 * @author O
 * @since 2020/3/26
 */
public class DominantIndex {
    public static void main(String[] args) {
        int[] nums0 = new int[]{3, 6, 1, 0};
        int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(dominantIndex(nums0));
        System.out.println(dominantIndex(nums1));
    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int idx = 0;
        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        for (int i = 0; i < len; i++) {
            if (i != idx) {
                if (2 * nums[i] > max) {
                    return -1;
                }
            }
        }
        return idx;
    }
}
