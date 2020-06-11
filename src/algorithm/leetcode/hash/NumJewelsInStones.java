package algorithm.leetcode.hash;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author O
 * @since 2020/3/16
 */
public class NumJewelsInStones {
    public static void main(String[] args) {
        String j1 = "aA";
        String s1 = "aAAbbbb";
        String j2 = "z";
        String s2 = "ZZ";
        System.out.println(numJewelsInStones(j1, s1) == 3);
        System.out.println(numJewelsInStones(j2, s2) == 0);
    }
    public static int numJewelsInStones(String J, String S) {
        final char[] j = J.toCharArray();
        final char[] s = S.toCharArray();
        Set<Character> diamondSet = new HashSet<>();
        for (char item : j) {
            diamondSet.add(item);
        }
        int count = 0;
        for (char item : s) {
            if (diamondSet.contains(item)) {
                count++;
            }
        }
        return count;
    }
}
