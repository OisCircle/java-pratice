package algorithm.leetcode.linklist;

/**
 * @author qiuchengquan
 * @since 2021/7/4
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	private static void print(ListNode head) {
		ListNode cur = head;
		StringBuilder sb = new StringBuilder();
		while (cur != null) {
			sb.append(cur.val + " -> ");
			cur = cur.next;
		}
		if (sb.length() > 1) {
			sb.delete(sb.length() - 4, sb.length());
		}
		System.out.println(sb.toString());
	}
}
