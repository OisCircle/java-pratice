package algorithm.stack;

import java.util.Stack;

/**
 * <p>
 * 剑指31题
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
}
