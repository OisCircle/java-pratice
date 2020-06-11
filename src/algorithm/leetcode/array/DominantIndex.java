package algorithm.leetcode.array;

/**
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
