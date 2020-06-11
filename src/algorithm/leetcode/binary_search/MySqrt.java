package algorithm.leetcode.binary_search;

/**
 * @author O
 * @since 2020/5/7
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 2, r = x / 2;
        int mid;
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
