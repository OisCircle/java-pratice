package algorithm.leetcode.linklist.cycle;

import algorithm.leetcode.linklist.ListNode;

/**
 * @author qiuchengquan
 * @since 2021/7/4
 */
public class HasCycle {

	public boolean hasCycle(ListNode head) {
		//1.一快一慢判断是否有环
		ListNode fast = head;
		ListNode slow = head;
		//fast跑的快，所以只需要判断fast的next指针
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
