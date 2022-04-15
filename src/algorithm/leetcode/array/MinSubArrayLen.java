package algorithm.leetcode.array;

/**
 * 满足符合长度为s的最小连续子数组长度
 *
 * 思路：维护左右两个指针，右指针一直累加，比如下面的case1，2+3+1+2=8刚刚好大于7，则右指针停下，左指针看下能不能尽量扣减，每次扣减都记录一个最小长度，7+4=11，之后左指针
 * 可以扣减2、3，长度是1+2+4=7，之后7+3=10，左指针右可以扣减1、2，刚刚好是7，也就是4+3
 *
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
