package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author O
 * @since 2020/3/27
 */
public class Generate {
    public static void main(String[] args) {
        generate(5).stream().forEach(nums -> {
            for (int i = 0; i < nums.size(); i++) {
                System.out.print(nums.get(i));
            }
            System.out.println();
        });
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> firstList = new ArrayList<>(1);
        firstList.add(1);
        res.add(firstList);
        for (int i = 2; i <= numRows; i++) {
            int[] nums = new int[i];
            final List<Integer> last = res.get(i - 2);
            nums[0] = 1;
            nums[i - 1] = 1;
            for (int j = 1; j < (i + 1) / 2; j++) {
                nums[j] = last.get(j - 1) + last.get(j);
                nums[i - j - 1] = nums[j];
            }
            List<Integer> list = new ArrayList<>(i);
            for (int n : nums) {
                list.add(n);
            }
            res.add(list);
        }
        return res;
    }

    public static List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                int temp = cur.get(j);
                cur.set(j, pre + cur.get(j));
                pre = temp;
            }
            cur.add(1);
        }
        return cur;
    }
}
