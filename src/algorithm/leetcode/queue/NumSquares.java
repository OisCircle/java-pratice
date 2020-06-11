package algorithm.leetcode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author O
 * @since 2020/3/21
 */
public class NumSquares {
    public static void main(String[] args) {
//        boolean result =
//                numSquares1(12) == 3 &&
//                        numSquares1(13) == 2 &&
//                        numSquares1(16) == 1;

        System.out.println(numSquares1(12));
//        System.out.println(numSquares1(13));
//        System.out.println(numSquares1(16));
//        System.out.println(result);
    }

    /**
     * 广度优先搜索
     */
    public static int numSquares(int n) {
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(n);
        q.offer(null);
        while (!q.isEmpty()) {
            final Integer cur = q.poll();
            if (cur == null) {
                step++;
                //分层相关
                if (q.peek() != null) {
                    q.offer(null);
                }
            } else if (cur == 0) {
                return step;
            } else {
                int t = (int) Math.sqrt(n);
                for (int i = 1; i <= t; i++) {
                    final int x = cur - i * i;
                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 动态规划
     * dp[i]:数字i最少由几个平方数构成
     * dp[i]=min ( dp[i] , dp[i - j*j] + 1 ) j ∈ j*j < i
     */
    public static int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
