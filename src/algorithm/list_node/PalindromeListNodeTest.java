package algorithm.list_node;

import java.util.Stack;

/**
 * <p>
 * 是否是回文链表
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/8
 */
public class PalindromeListNodeTest {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);


		head.next = l2;
		l2.next = l3;
		l3.next = l4;

		head.print();

		System.out.println(isPalindrome(head));

	}

	static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		Stack<ListNode> in = new Stack<>();
		Stack<ListNode> out = new Stack<>();

		ListNode headIn = head;
		int count = 0;
		//calculate count of the list node
		while (headIn != null) {
			in.push(headIn);
			headIn = headIn.next;
			count++;
		}
		int temp = count;
		boolean isOddCount = (temp & 1) == 1;
		//load half of in into out stack
		while (temp-- > count / 2) {
			out.push(in.pop());
		}
		if (isOddCount) {
			out.pop();
		}
		boolean result = true;
		while (temp-- >= 0) {
			if (in.pop().val != out.pop().val) {
				result = false;
				break;
			}
		}
		return result;
	}

}
