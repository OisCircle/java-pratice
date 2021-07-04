package algorithm.leetcode.linklist.removeNthFromEnd;

import algorithm.leetcode.linklist.ListNode;

/**
 * 删除链表的倒数第N个节点
 * <p>
 * https://leetcode-cn.com/leetbook/read/linked-list/jf1cc/
 *
 * @author qiuchengquan
 * @since 2021/7/4
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		//添加入口节点，不用判断删除head的特殊情况
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode slow = dummyHead, fast = dummyHead;
		while (n-- > 0) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummyHead.next;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (n-- > 0) {
			fast = fast.next;
		}
		//null的代表删除的是第一个节点
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
