package algorithm.list_node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <p>
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class PrintListNodeFromEndToHead {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(printListFromTailToHead(n1));
	}

	static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> res = new ArrayList<>(stack.size());
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}
}
