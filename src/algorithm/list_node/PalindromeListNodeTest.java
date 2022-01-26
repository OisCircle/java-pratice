package algorithm.list_node;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Stack;

/**
 * <p>
 *
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
//		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(1);

		head.next = l2;
		l2.next = l3;
		l3.next = l4;

		System.out.println(isPalindrome(head));
		System.out.println(isPalindrome2(head));
		System.out.println(isPalindrome3(head));

		ListNode a0 = new ListNode(1);
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(1);

		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;

		System.out.println("--------");

		System.out.println(isPalindrome(a0));
		System.out.println(isPalindrome2(a0));
		System.out.println(isPalindrome3(a0));
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

	/**
	 * 解法1不理智，回文字符串就是倒着念也可以一样，用一个栈就可以判断出来
	 */
	static boolean isPalindrome2(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop().val != head.val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	private static ListNode compareNode;
	private static boolean isOddCount;

	/**
	 * 递归解法，1 2 2 1为例，递归到第二个节点（1，2），开始回退，每回退一个节点，就跟后面的进行对比（2，1）
	 */
	static boolean isPalindrome3(ListNode head) {
		int count = 0;
		ListNode cur = head;
		boolean[] res = new boolean[]{true};
		while (cur != null) {
			cur = cur.next;
			count++;
		}
		isOddCount = (count & 1) == 1;
		count = count / 2;
		compareNode = cur;
		rec(1, count, head, res);
		return res[0];
	}

	static void rec(int currentCount, int count, ListNode cur, boolean[] res) {
		if (currentCount > count) {
			//奇数的话要跳过中间那个
			if (isOddCount) {
				compareNode = cur.next;
			} else {
				compareNode = cur;
			}
			return;
		}
		rec(currentCount + 1, count, cur.next, res);
		if (!res[0]) {
			return;
		}
		res[0] = cur.val == compareNode.val;
		compareNode = compareNode.next;
	}
}