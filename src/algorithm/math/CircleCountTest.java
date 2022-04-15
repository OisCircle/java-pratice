package algorithm.math;

/**
 * <p>
 * (动态规划)
 * 剑指45：圆圈中剩下的数字
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列并且不再回到圈中,从他的下一个小朋友开始,继续0…m-1报数….这样下去….直到剩下最后一个小朋友,求最后一个小朋友的编号
 * (注：小朋友的编号是从0到n-1)
 * <p>
 * 这道题是著名的约瑟夫环问题，举个例子，现在有6个人，编号从0到5,每次删除第3个人。
 *                 0,1,2,3,4,5
 * 第一次删除2，还剩 0,1, ,3,4,5 然后从3开始继续报数和删除的过程
 * 第二次删除5，还剩 0,1, ,3,4,  然后从0开始继续
 * 第三次删除3，还剩 0,1, , ,4,  然后从4开始继续
 * 第四次删除1，还剩 0, , , ,4,  然后从4开始继续
 * 第五次删除4，还剩 0, , , , ,  结束
 *
 * 对比下5个人,编号从0到4,每次删除第3个人的情况。
 *                 0,1,2,3,4
 * 第一次删除2，还剩 0,1, ,3,4 然后从3开始继续报数和删除的过程
 * 第二次删除0，还剩  ,1, ,3,4 然后从1开始继续
 * 第三次删除4，还剩  ,1, ,3,  然后从1开始继续
 * 第四次删除1，还剩  , , ,3,  结束
 *
 * 有这个规律 f(6,3)=(f(5,3)+3)%6=(3+3)%6=0
 *
 * @author O
 * @version 1.0
 * @since 2019/4/12
 */
public class CircleCountTest {
	public static void main(String[] args) {
//		getLast(5, 1);
//		getLast(5, 2);
//		getLast(5, 3);
		getLast(10, 3);
		getLast(11, 3);
	}

	/**
	 * 最易理解的文章
	 * https://blog.csdn.net/u011500062/article/details/72855826
	 * 思路：f(n,m)=(f(n-1,m)+m)%n
	 * f(n,m)代表n个人，数m次，最后剩下的人的下标。
	 * f(n-1,m)(n-1个人,数m次,最后剩下的人的下标)向右移动m格,就到了f(n,m)所在的位置了,防止数组越界,需要膜上n,来到数组的前面
	 */
	static void print(int n, int m) {
		if (n < 1 || m < 1) {
			System.out.println("invalid input");
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
	}


	static void getLast(int n, int m) {
		if (n < 1 || m < 1) {
			System.out.println("invalid input");
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		System.out.println(last);
	}
}
