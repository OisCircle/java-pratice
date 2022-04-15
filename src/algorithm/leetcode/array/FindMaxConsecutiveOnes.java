package algorithm.leetcode.array;

/**
 * 连续的1最长的长度
 *
 * 思路：边遍历，记录1最长记录，并且记录count，遇到count=0直接重新将count进行归位
 *
 * @author O
 * @since 2020/3/28
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        //3
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        //2
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        //1
        System.out.println(findMaxConsecutiveOnes(new int[]{1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = count > max ? count : max;
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
