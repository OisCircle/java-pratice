package algorithm.stack;

import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class TwoStackToQueueTest2 {
	public static void main(String[] args) {
		TwoStackToQueueTest2 queue = new TwoStackToQueueTest2();
		System.out.println(queue.pop());
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}

	private Stack<Integer> in = new Stack<>();
	private Stack<Integer> out = new Stack<>();

	public void push(int node) {
		in.push(node);
	}

	public int pop() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		if (out.isEmpty()) {
			return -1;
		}
		return out.pop();
	}
}
