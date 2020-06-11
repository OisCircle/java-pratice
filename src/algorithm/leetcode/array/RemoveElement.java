package algorithm.leetcode.array;

/**
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
        return idx;
    }
}
