package algorithm.leetcode.array;

/**
 *
 * 寻找数组中心的索引
 *
 * 比如下面的case（nums0）
 *
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 思路1：双指针法，左右指针一直遍历直到相遇，边遍历边统计各自的sum
 *
 * 思路2：先一遍循环获取数组的sum，再从头开始遍历，边遍历边统计leftSum，直到leftSum*2+cur=sum
 *
 *
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
