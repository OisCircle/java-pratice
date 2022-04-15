package algorithm.leetcode.binary_search;

/**
 *
 * 排序数组里面搜索指定数字出现的下标范围
 *
 * 思路：分三次二分搜索
 * 1 搜索出该数字的下标
 * 2 左边二分搜索搜索最左边的下标
 * 3 右边二分搜索搜索最右边的下标
 *
 * @author O
 * @since 2020/5/11
 */
public class SearchRange {
    public static void main(String[] args) {
        //1,3
        int[] res0 = searchRange(new int[]{1, 2, 2, 2, 5, 6, 7, 8}, 2);
        System.out.println(res0[0] + " , " + res0[1]);
        //3,5
        int[] res1 = searchRange(new int[]{1, 2, 3, 4, 4, 4, 7, 8}, 4);
        System.out.println(res1[0] + " , " + res1[1]);
        //5,7
        int[] res2 = searchRange(new int[]{1, 2, 3, 4, 5, 6, 6, 6}, 6);
        System.out.println(res2[0] + " , " + res2[1]);
        //0,7
        int[] res3 = searchRange(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 1);
        System.out.println(res3[0] + " , " + res3[1]);
        //4,4
        int[] res4 = searchRange(new int[]{1, 2, 3, 4, 5, 6, 6, 6}, 5);
        System.out.println(res4[0] + " , " + res4[1]);
        //-1,-1
        int[] res5 = searchRange(new int[]{1, 3, 5}, 2);
        System.out.println(res5[0] + " , " + res5[1]);
        //0,3
        int[] res6 = searchRange(new int[]{2, 2, 2, 2, 5, 6, 7, 8}, 2);
        System.out.println(res6[0] + " , " + res6[1]);
        //0,0
        int[] res7 = searchRange(new int[]{1}, 1);
        System.out.println(res7[0] + " , " + res7[1]);
        //-1,-1
        int[] res8 = searchRange(new int[]{1}, 2);
        System.out.println(res8[0] + " , " + res8[1]);
        //0,1
        int[] res9 = searchRange(new int[]{1, 1}, 1);
        System.out.println(res9[0] + " , " + res9[1]);
        //1,1
        int[] res10 = searchRange(new int[]{1, 2, 3}, 2);
        System.out.println(res10[0] + " , " + res10[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0, r = nums.length - 1, mid = (l + r) / 2;
        //找出target==mid的下标
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                break;
            }
        }
        mid = (l + r) / 2;
        System.out.println("left: " + l + " , right: " + r + " , mid: " + mid);
        //只有一个，首尾相同
        if (mid > 0 && mid < nums.length - 1 && nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
            res[0] = mid;
            res[1] = mid;
            return res;
        }
        if (l == r && nums[l] == target) {
            res[0] = l;
            res[1] = l;
            return res;
        }
        //不存在
        if (l >= r) {
            return res;
        }
        int l1 = l, r1 = mid, mid1 = (l1 + r1) / 2;
        int l2 = mid, r2 = r, mid2 = (l2 + r2) / 2;
        //找出第一个
        while (mid1 != 0 && !(nums[mid1] == target && nums[mid1 - 1] != target)) {
            mid1 = (l1 + r1) / 2;
            if (nums[mid1] == target) {
                r1 = mid1;
            } else {
                l1 = mid1 + 1;
            }
        }
        //找出最后一个
        while (mid2 != nums.length - 1 && !(nums[mid2] == target && nums[mid2 + 1] != target)) {
            mid2 = (l2 + r2) / 2;
            if (nums[mid2] == target) {
                l2 = mid2 + 1;
            } else {
                r2 = mid2;
            }
        }
        res[0] = mid1;
        res[1] = mid2;
        return res;
    }
}
