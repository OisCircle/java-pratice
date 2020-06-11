package algorithm.leetcode.array;

/**
 * @author O
 * @since 2020/3/25
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums0 = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums0));
        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(pivotIndex(nums1));
        int[] nums2 = new int[]{-1, -1, -1, -1, -1, 0};
        System.out.println(pivotIndex(nums2));
    }

    public static int pivotIndex(int[] nums) {
        final int len = nums.length;
        int sum = 0;
        int leftSum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (sum == 2 * leftSum + nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
