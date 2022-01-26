package algorithm.list_node;

import java.util.Stack;

/**
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/8
 */
public class InverseListNodeTest {
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

		head.print();

//		reverseList(head).print();
//		reverseListLoop2(head).print();
//		reverseListLoop(head).print();
		stackReverseList(head).print();
//		n5.print();
	}


	static ListNode reverseListLoop(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode last = null;
		ListNode current = head;
		ListNode next;
		while (current != null) {
			next = current.next;
			current.next = last;
			last = current;
			current = next;
		}
		return last;
	}

	static ListNode reverseListLoop2(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode pre = null, next, cur = head;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}


	static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head;
		while (newHead.next != null) {
			newHead = newHead.next;
		}
		reverseList(head, head.next);
		return newHead;
	}

	static void reverseList(ListNode last, ListNode next) {
		if (next.next != null) {
			System.out.println(last.val + " into " + last.next.val);
			reverseList(last.next, next.next);
		}

		System.out.println(next.val + " -> " + last.val);
		next.next = last;
		//anti loop listnode
		last.next = null;
	}

	static ListNode stackReverseList(ListNode cur) {
		if (cur == null || cur.next == null) {
			return cur;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		cur = stack.pop();
		head = cur;
		while (!stack.isEmpty()) {
			ListNode pop = stack.pop();
			cur.next = pop;
			cur = pop;
		}
		cur.next = null;
		return head;
	}
}

