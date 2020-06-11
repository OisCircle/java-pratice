package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author O
 * @since 2020/3/28
 */
public class ArrayPairSum {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(arrayPairSum(new int[]{1, 2, 3, 4}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            sum += Math.min(nums[l], nums[l + 1]);
            if (l + 1 != r) {
                sum += Math.min(nums[r], nums[r - 1]);
            }
            l += 2;
            r -= 2;
        }
        return sum;
    }
}
