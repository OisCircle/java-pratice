package algorithm.leetcode.array;

/**
 * 剑指Offer专项突破版 第八题 合大于或等于k的最短子数组
 * <p>
 * 思路：双指针（l，r）一起从左边开始，累计合小于k则r向右移动，累计合大于k则l向左移动，移动过程中不断记录历史最小子数组长度
 *
 * @author O
 * @since 2020/3/28
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        //2
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        //3
        System.out.println(minSubArrayLen(10, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen2(10, new int[]{1, 2, 3, 4, 5}));
        //2
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        System.out.println(minSubArrayLen2(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        //2
        System.out.println(minSubArrayLen(5, new int[]{2, 3, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen2(5, new int[]{2, 3, 1, 1, 1, 1, 1}));
        //0
        System.out.println(minSubArrayLen(3, new int[]{1, 1}));
        System.out.println(minSubArrayLen2(3, new int[]{1, 1}));
    }

    public static int minSubArrayLen2(int k, int[] nums) {
        int len = nums.length;
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        //r指针向前找
        for (int r = 0; r <= len - 1; r++) {
            sum += nums[r];
            //找到大于k的下标，则l向右试图搜索更小更符合条件的数组长度
            while (sum >= k && l <= r) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        //如果minLen没变过，说明数组累计合都没有大于k，这时候无符合条件的最小数组
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
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
