package algorithm.leetcode.array;

import java.util.Arrays;

/**
 *
 * 数组拆分 I
 *
 * 先排序，后奇数位之合就是最大值
 *
 * @author O
 * @since 2020/3/28
 */
public class ArrayPairSum {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(arrayPairSum2(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(arrayPairSum(new int[]{1, 2, 3, 4}));
        System.out.println(arrayPairSum2(new int[]{1, 2, 3, 4}));
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
    public static int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
