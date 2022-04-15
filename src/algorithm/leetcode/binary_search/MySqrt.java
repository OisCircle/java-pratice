package algorithm.leetcode.binary_search;

/**
 * 求x的平方根，不用表示小数点，可以表示整数
 *
 * 思路：根号20，4^2=16,5^2=25，那么根号20一定是4～5之间，取整4即可。
 * 需要用到二分搜索，从2～x/2，逐个比较即可，注意x>4的情况下根号x<x/2才成立，x小于4，则直接返回x即可，因为结果都是1
 *
 * @author O
 * @since 2020/5/7
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(20));
        System.out.println(mySqrt(10));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(2));
    }
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 2, r = x / 2;
        int mid;
        //x小于4，则直接返回x即可，因为结果都是1
        while (l <= r) {
            //这个其实就是相当于(l+r)/2; 下面的写法是为了避免大数字溢出
            mid = l + (r - l) / 2;
            long num = (long) mid * mid;
            if (num > x) {
                r = mid - 1;
            } else if (num < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }
}
