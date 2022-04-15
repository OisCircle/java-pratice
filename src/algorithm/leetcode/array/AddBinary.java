package algorithm.leetcode.array;

import java.math.BigInteger;

/**
 *
 * 二进制相加
 *
 * @author O
 * @since 2020/3/27
 */
public class AddBinary {
    public static void main(String[] args) {
        //100
        String a0 = "11", b0 = "1";
        //10101
        String a1 = "1010", b1 = "1011";
        //0
        String a2 = "0", b2 = "0";
        //1
        String a3 = "0", b3 = "1";
        //110110
        String a4 = "100", b4 = "110010";
        //11110
        String a5 = "1111", b5 = "1111";
        System.out.println(addBinary(a0, b0));
        System.out.println(addBinary(a1, b1));
        System.out.println(addBinary(a2, b2));
        System.out.println(addBinary(a3, b3));
        System.out.println(addBinary(a4, b4));
        System.out.println(addBinary(a5, b5));

        final BigInteger integer = new BigInteger("1001", 2);
        System.out.println(integer);

    }

    public static String addBinary(String a, String b) {
        final char[] cha = a.toCharArray();
        final char[] chb = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int forward = 0;
        for (int i = 1; i <= Math.max(cha.length, chb.length); i++) {
            int n1 = i <= cha.length ? (int) cha[cha.length - i] - (int) '0' : 0;
            int n2 = i <= chb.length ? (int) chb[chb.length - i] - (int) '0' : 0;
            if (n1 + n2 + forward == 3) {
                sb.append("1");
                forward = 1;
            } else if (n1 + n2 + forward == 2) {
                sb.append("0");
                forward = 1;
            } else if (n1 + n2 + forward == 1) {
                sb.append("1");
                forward = 0;
            } else {
                sb.append('0');
                forward = 0;
            }
        }
        if (forward == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
