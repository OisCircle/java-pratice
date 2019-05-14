import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * 例1：
 * 输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到第二个元素a[1]=2,
 * 再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2)后,向后数组越界,即跳出数组,输出true;
 * 例2：
 * 输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动1位到第二个元素a[1]=-3,再次向前移动3位后,
 * 向前数组越界,即跳出数组,输出true;
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		line = line.substring(1, line.length() - 1);
		String[] strs=line.split(",");
		int[] arr = new int[strs.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(strs[i]);
		}
		print(arr);

		print(new int[]{2, 1, 3, 5});
		print(new int[]{2, 1, -3});
		print(new int[]{1, 1, 1, 2, -1, 1, -3});
		print(new int[]{1});
		print(new int[]{0});
		print(new int[]{1, -1});

	}

	private static void print(int[] arr) {
		int len = arr.length;
		int cur = 0;
		int count = 0;
		while (cur >= 0 && cur < len && count <= len * len) {
			if (arr[cur] > 0) {
				cur += arr[cur];
			} else if (arr[cur] < 0) {
				cur += arr[cur];
			} else {
				System.out.println(false);
				return;
			}
			count++;
		}
		if (count > len * len) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
	}
}
