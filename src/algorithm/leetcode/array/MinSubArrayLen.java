package algorithm.leetcode.array;

/**
 * @author O
 * @since 2020/3/28
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        //2
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        //3
        System.out.println(minSubArrayLen(10, new int[]{1, 2, 3, 4, 5}));
        //2
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        //2
        System.out.println(minSubArrayLen(5, new int[]{2, 3, 1, 1, 1, 1, 1}));
        //0
        System.out.println(minSubArrayLen(3, new int[]{1, 1}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int curLen = 0;
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            sum += cur;
            while (sum >= s) {
                sum -= nums[left++];
                curLen = i - left + 2;
                minLen = Math.min(minLen, curLen);
            }
//            if (sum >= s) {
//                curLen = i - left + 1;
//                minLen = curLen < minLen ? curLen : minLen;
//                while (sum - nums[left] >= s) {
//                    sum -= nums[left++];
//                    curLen = i - left + 1;
//                    minLen = Math.min(minLen,curLen);
//                }
//            }
        }
        return Math.min(curLen, minLen);
    }
}
