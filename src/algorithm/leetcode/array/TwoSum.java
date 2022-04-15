package algorithm.leetcode.array;

import java.util.Arrays;

/**
 *
 * 排序数组，两数之合刚好等于target的数字对应的下标位置
 *
 * @author O
 * @since 2020/3/28
 */
public class TwoSum {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{1, 2, 3, 4, 5, 7}, 5)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(twoSum(new int[]{1, 2, 3}, 9)).forEach(System.out::print);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                break;
            }
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        if (l == r) {
            return new int[0];
        }
        return new int[]{++l, ++r};
    }
}
