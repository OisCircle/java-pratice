package algorithm.stack;

import java.util.Stack;

/**
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/16
 */
public class PopSequenceTest2 {
	public static void main(String[] args) {
		System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
		System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));

	}

	static boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA.length != popA.length) {
			return false;
		}
		int len = pushA.length;
		Stack<Integer> s = new Stack<>();
		int popIndex=0;
		for (int i = 0; i < len; i++) {
			s.push(pushA[i]);
			while (!s.isEmpty() && s.peek() == popA[popIndex]) {
				s.pop();
				popIndex++;
			}
		}
		return s.isEmpty();
	}
}
