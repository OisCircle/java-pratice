package algorithm.leetcode.queue;

import java.util.*;

/**
 * @author O
 * @since 2020/3/21
 */
public class OpenLock {
    private static int count;

    public static void main(String[] args) {
        String[] deadend0 = {"0201", "0101", "0102", "1212", "2002"};
        String target0 = "0202";
        String[] deadend1 = {"8888"};
        String target1 = "0009";
        String[] deadend2 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target2 = "8888";
        String[] deadend3 = {"0000"};
        String target3 = "8888";

//        System.out.println(openLock(deadend0, target0));
//        System.out.println(openLock(deadend1, target1));
//        System.out.println(openLock(deadend2, target2));
//        System.out.println(openLock(deadend3, target3));
        boolean result =
                openLock(deadend0, target0) == 6 &&
                        openLock(deadend1, target1) == 1 &&
                        openLock(deadend2, target2) == -1 &&
                        openLock(deadend3, target3) == -1;
        System.out.println(result);
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> used = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String cur = "0000";
        used.add(cur);
        q.offer(cur);
        //遇到null则层次加一
        q.offer(null);
        int level = 0;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur == null) {
                level++;
                //为下一层打上记号，这里要判断下一个cur是否为空，为空则说明已经遍历到尽头了
                if (q.peek() != null) {
                    q.offer(null);
                }
            } else if (target.equals(cur)) {
                return level;
            }
            //如果遇见死锁，不再尝试这个分支
            else if (!dead.contains(cur)) {
                //尝试所有可能，每个位置转动两次
                offer(q, cur, used);
            }
        }
        return -1;
    }

    private static void offer(Queue<String> q, String cur, Set<String> used) {
        for (int i = 0; i < 4; i++) {
            char[] chs0 = cur.toCharArray();
            char[] chs1 = cur.toCharArray();
            int numMinus = (int) cur.charAt(i) - (int) '0';
            chs0[i] = (char) ((numMinus - 1 + 10) % 10 + (int) '0');
            String s0 = new String(chs0);
            int numPlus = (int) cur.charAt(i) - (int) '0';
            chs1[i] = (char) ((numPlus + 1 + 10) % 10 + (int) '0');
            String s1 = new String(chs1);
            if (!used.contains(s0)) {
                q.offer(s0);
                used.add(s0);
            }
            if (!used.contains(s1)) {
                q.offer(s1);
                used.add(s1);
            }
        }
    }
}
