package algorithm.leetcode.stack;

/**
 * @author O
 * @since 2020/3/23
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5);
        System.out.println(findTargetSumWays(new int[]{1, 1, 1}, 3) == 1);
    }

    private static int result;

    public static int findTargetSumWays(int[] nums, int S) {
        result = 0;
        dfs(nums, S, 0, 0);
        return result;
    }

    private static void dfs(int[] nums, int S, int cur, int idx) {
        if (cur == S && idx == nums.length) {
            result++;
        } else if (idx < nums.length) {
            dfs(nums, S, cur + nums[idx], idx + 1);
            dfs(nums, S, cur - nums[idx], idx + 1);
        }
    }
}
