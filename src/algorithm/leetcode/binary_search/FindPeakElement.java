package algorithm.leetcode.binary_search;

/**
 * 一个升序再降序的数组，寻找峰值
 *
 * 关键思路：
 * 1.mid>mid+1，说明现在是上坡，顶峰在右边
 * 2.mid<mid+1，说明现在是下坡，顶峰在左边
 * 3.注意边界值r=mid,l=mid+1，目的是让l<r成立，返回l
 *
 * findPeakElement0解法任意理解一点，二分最终都会让lr相邻，相邻的时候取一个最大的即可，不用去注意上面的关键思路3.，比较绕
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
        	//lr相邻，说明最大值在这两个之中
            if (l + 1 == r) {
                return nums[l] < nums[r] ? r : l;
            }
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return -1;
    }
}
