package algorithm.stack;

import java.util.Stack;

/**
 * <p>
 * 剑指31题
 *
 * 给一个压入序列，和弹出序列，判断是不是弹出序列
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/15
 */
public class PopSequenceTest {
	public static void main(String[] args) {
		int[] sequenceIn = new int[]{1, 2, 3, 4, 5};
		int[] sequenceOut = new int[]{4, 5, 3, 2, 1};
		int[] sequenceOut2 = new int[]{4, 3, 5, 1, 2};

		System.out.println(isPopSequence(sequenceIn, sequenceOut));
		System.out.println(isPopSequence(sequenceIn, sequenceOut2));
		System.out.println(isPopSequence(sequenceIn, null));
		System.out.println(isPopSequence(null, null));
		System.out.println(isPopSequence(null, sequenceOut2));

		System.out.println("-------");
		System.out.println(isPopSequence1(sequenceIn, sequenceOut));
		System.out.println(isPopSequence1(sequenceIn, sequenceOut2));
	}

	static boolean isPopSequence(int[] sequenceIn, int[] sequenceOut) {
		if (sequenceIn == null || sequenceOut == null || sequenceIn.length != sequenceOut.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int inIndex = 0;
		int outIndex = 0;

		while (inIndex < sequenceIn.length) {
			stack.push(sequenceIn[inIndex]);
			inIndex++;
			while (!stack.isEmpty() && stack.peek() == sequenceOut[outIndex]) {
				outIndex++;
				stack.pop();
			}
			if (stack.isEmpty() && inIndex == sequenceIn.length) {
				return true;
			}
		}
		return false;
	}

	static boolean isPopSequence1(int[] sequenceIn, int[] sequenceOut) {
		Stack<Integer> stack = new Stack<>();
		int inIndex = 0, outIndex = 0;
		while (inIndex < sequenceIn.length) {
			stack.push(sequenceIn[inIndex++]);
			//每压一个，都循环判断一批
			while (!stack.isEmpty() && stack.peek() == sequenceOut[outIndex]) {
				stack.pop();
				outIndex++;
			}
		}
		//为空说明全部序列匹配成功，不为空说明部分序列匹配失败
		return stack.isEmpty();
	}
}
