package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 找出排序数组中合为target的两个下标
 *
 * 无脑O（n^2）解法1：固定一个数字，遍历剩余所有其它下标数字
 *
 * O（n）解法2：双指针，一头一尾，头尾数字sum大于target则尾指针-1，否则头指针+1
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
