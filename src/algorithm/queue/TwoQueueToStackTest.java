package algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 两个队列实现栈，用一个计数器记录数量，然后将a的n-1个进入b，再弹出a，接下来的操作重复，复制到a，再弹出b，循环
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class TwoQueueToStackTest {
	public static void main(String[] args) throws Exception{
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.push(3);
		stack.pop();
		stack.pop();
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.pop();
		stack.pop();
		stack.pop();

	}


}

class MyStack {
	private Queue<Integer> q1, q2;
	private boolean isQueue1ToOffer;
	private int counter;
	MyStack() {
		isQueue1ToOffer = true;
		counter = 0;
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(int value) {
		if (isQueue1ToOffer) {
			q1.offer(value);
		} else {
			q2.offer(value);
		}
		counter++;
	}

	public int pop() throws Exception{
		int limit = counter;
		int result;
		if (q1.isEmpty() && q2.isEmpty()) {
			throw new Exception("stack is empty");
		}
		if (isQueue1ToOffer) {
			while (limit-- > 1) {
				q2.offer(q1.poll());
			}
			isQueue1ToOffer = !isQueue1ToOffer;
			result= q1.poll();
		} else {
			while (limit-- > 1) {
				q1.offer(q2.poll());
			}
			isQueue1ToOffer = !isQueue1ToOffer;
			result= q2.poll();
		}
		counter --;
		return result;
	}


}
