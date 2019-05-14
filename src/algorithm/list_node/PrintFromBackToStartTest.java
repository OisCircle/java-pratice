package algorithm.list_node;

import java.util.Stack;

/**
 * <p>
 * 从尾到头打印链表
 * 解法1：递归到最后，再输出
 * 解法2：栈
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/13
 */
public class PrintFromBackToStartTest {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		printRecursively(head);
		System.out.println("\n------------");
		printStack(head);
	}

	static void printRecursively(ListNode head) {
		if (head == null) {
			return;
		}
		printRecursively(head.next);
		System.out.print(head.val + " -> ");
	}

	static void printStack(ListNode head) {
		if (head == null) {
			return;
		}
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().val + " -> ");
		}
	}

}
