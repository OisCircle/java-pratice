package algorithm.leetcode.array;

/**
 *
 * 删除重复元素，并返回数组最终长度
 *
 * 思路：以case2为例，0、1后面有两个2，说明后面的数据都要往前移动2位，可以边遍历边覆盖，如果i的值等于val，则跳过覆盖操作，直到后面的数据又再次不相等。
 * 这么处理恰好可以把前面的都给覆盖掉
 *
 * @author O
 * @since 2020/3/28
 */
public class RemoveElement {
    public static void main(String[] args) {
        //2
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        //5
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        return idx;
    }
}
