package algorithm.math;

/**
 * <p>
 * 剑指45：圆圈中剩下的数字
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列并且不再回到圈中,从他的下一个小朋友开始,继续0…m-1报数….这样下去….直到剩下最后一个小朋友,求最后一个小朋友的编号
 * (注：小朋友的编号是从0到n-1)
 * <p>
 * 这道题是著名的约瑟夫环问题，举个例子，现在有6个人，编号从0到5，每次删除第3个人。
 * 第一次删除2，还剩 0,1,3,4,5，然后从3开始继续报数和删除的过程
 * 第二次删除5，还剩 0,1,3,4, 然后从0开始继续
 * 第三次删除3，还剩 0,1,4, 然后从4开始继续
 * 第四次删除1，还剩 0,4, 然后从4开始继续
 * 第五次删除4，还剩 0，结束
 *
 * 如下case(n=7, m=3)，大写字母代表每次被删除的，每次删除之后，都从大写字母的下一个开始算起
 *
 * 观察如下规律可以知道：每次删除之后，所有元素都向前移动3格
 *
 * 定义f(n,m)代表当前规则下，存活下来的人，下标是多少，得出如下规律
 *
 * f(n,m) = (f(n-1,m) + m) % n
 *
 * 0 1 2 3 4 5 6
 * a b C d e f g（7个人的时候，d必须站在下标4这里）f(7,3) = (f(6,3) + 3) % 7
 * d e F g a b（6个人的时候，d必须站在下标1这里）f(6,3) = (f(5,3) + 3) % 6
 * g a B d e（5个人的时候，d必须站在下标3这里）f(5,3) = (f(4,3) + 3) % 5
 * d e G a（4个人的时候，d必须站在下标0这里）f(4,3) = (f(3,3) + 3) % 4
 * a d E（3个人的时候，d必须站在下标1这里）f(3,3) = (f(2,3) + 3) % 3
 * A d（2个人的时候，d必须站在下标1这里）f(2,3) = (f(1,3) + 3) % 2
 * d（1个人的时候，d必须站在下标0这里）f(1,3) = 0
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
		getLast(6, 3);
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
