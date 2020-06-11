package algorithm.leetcode.binary_search;

/**
 * 关键思路：
 * 1.mid>mid+1，说明现在是上坡，顶峰在右边
 * 2.mid<mid+1，说明现在是下坡，顶峰在左边
 * 3.注意边界值r=mid,l=mid+1，目的是让l<r成立，返回l
 *
 * @author O
 * @since 2020/5/11
 */
public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1}));
        System.out.println(findPeakElement0(new int[]{1, 2, 3, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1}));
    }

    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                //下坡路，峰值在左边
                r = mid;
            else
                //上坡路，峰值在右边
                l = mid + 1;
        }
        return l;
    }

    public static int findPeakElement0(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
