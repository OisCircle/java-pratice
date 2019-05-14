package algorithm.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class FindNumsAppearOnceTest {
	public static void main(String[] args) {
		findNumsAppearOnce(new int[]{1, 1, 2, 3, 3, 4, 4, 5}, new int[1], new int[1]);

	}

	static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int len = array.length;
		Set<Integer> set = new HashSet<>(len);

		for (int i = 0; i < len; i++) {
			if (set.contains(array[i])) {
				set.remove(array[i]);
			} else {
				set.add(array[i]);
			}
		}
		Iterator<Integer> i = set.iterator();
		num1[0] = i.next();
		num2[0] = i.next();
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}
}
