package algorithm.stack;

import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/9
 */
public class MinStackTest {
	public static void main(String[] args) {

		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(3);

		stack.pop();
		int param_3 = stack.top();
		int param_4 = stack.getMin();

		System.out.println(param_3);
		System.out.println(param_4);
	}

}

class MinStack {
	private Stack<Integer> realStack;
	private Stack<Integer> minStack;

	MinStack() {
		realStack = new Stack<>();
		minStack = new Stack<>();
	}


	public void push(int x) {
		realStack.push(x);
		if (!minStack.empty()) {
			boolean isSmaller = minStack.peek() > x;
			minStack.push(isSmaller ? x : minStack.peek());
		} else {
			minStack.push(x);
		}
	}

	public void pop() {
		if (!realStack.empty()) {
			realStack.pop();
		}
		if (!minStack.empty()) {
			minStack.pop();
		}
	}

	public int top() {
		return realStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}