package algorithm.leetcode.binary_search;

/**
 * 需要画图理解数字性质，只有四种情况出现
 * 1.上坡
 * 2.下坡
 * 3.nums[l]>nums[mid]
 * 4.nums[l]<nums[mid]
 *
 * @author O
 * @since 2020/5/11
 */
public class FindMin {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2, 3}));
        System.out.println(findMin(new int[]{3, 2, 1}));
        System.out.println(findMin(new int[]{2, 3, 1}));
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //判断是不是走上坡
            if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) {
                return nums[l];
            }
            //判断是不是走下坡
            if (nums[l] >= nums[mid] && nums[mid] >= nums[r]) {
                return nums[r];
            }
            //判断该在左边寻找还是在右边寻找
            if (nums[l] > nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return nums[0];
    }
}
