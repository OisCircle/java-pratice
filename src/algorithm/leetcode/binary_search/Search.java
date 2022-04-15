package algorithm.leetcode.binary_search;

/**
 *
 * 旋转数组的搜索
 *
 * @author O
 * @since 2020/5/7
 */
public class Search {
    public static void main(String[] args) {
        test0();
    }

    private static void test0() {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int[] nums2 = new int[]{4, 5, 1, 2, 3};
        int[] nums3 = new int[]{3, 1};
        int[] nums4 = new int[]{3, 5, 1};
        System.out.println(search(nums, 1));
        System.out.println(search(nums2, 1));
        System.out.println(search(nums2, 10));
        System.out.println(search(nums3, 0));
        System.out.println(search(nums4, 3));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //旋转
            if (nums[l] > nums[r]) {
                //需要画图理解，画两段三角形即可，三角形一边大一边小，就可以分成下面这4种情况
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else if (target >= nums[mid] && target <=nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                //非旋转
                if (target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
