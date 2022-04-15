package algorithm.list_node;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/8
 */
public class MergeTwoLists {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);

		ListNode l2 = new ListNode(1);
		ListNode l21 = new ListNode(3);
		ListNode l22 = new ListNode(4);

		ListNode l3 = new ListNode(1);
		ListNode l31 = new ListNode(4);
		ListNode l32 = new ListNode(5);

		l1.next = l11;
		l11.next = l12;
		l2.next = l21;
		l21.next = l22;
		l3.next = l31;
		l31.next = l32;

		l1.print();
		l2.print();
		l3.print();

		mergeManyLists(Arrays.asList(l1, l2, l3)).print();

//		mergeTwoLists(l1, l2).print();
//		mergeTwoLists2(l1, l2).print();

//		mergeTwoLists(l2, l1).print();

//		mergeTwoLists(null, l1).print();

//		mergeTwoLists(l1, null).print();

//		mergeTwoLists(null, null).print();

//		mergeTwoListsRecursively(l1, l2).print();
	}

	static ListNode mergeTwoListsRecursively(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode node = null;
		if (l1.val < l2.val) {
			node = l1;
			node.next = mergeTwoListsRecursively(l1.next, l2);
		} else {
			node = l2;
			node.next = mergeTwoListsRecursively(l1, l2.next);
		}
		return node;
	}

	static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//注意边界判断
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		//使用一个cur即可
		ListNode cur, head;
		if (l1.val < l2.val) {
			cur = l1;
			l1 = l1.next;
		} else {
			cur = l2;
			l2 = l2.next;
		}
		head = cur;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					cur.next = l1;
					l1 = l1.next;
				} else {
					cur.next = l2;
					l2 = l2.next;
				}
			} else if (l1 != null) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		return head;
	}

	//简约版本的
	static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(-1);
		ListNode cur = newHead;
		while (l1 != null && l2 != null) {
			ListNode min = l1.val < l2.val ? l1 : l2;
			if (l1.val < l2.val) {
				l1 = l1.next;
			} else {
				l2 = l2.next;
			}
			cur.next = min;
			cur = cur.next;
		}
		//任意一条路走到尽头，直接挂到另一条路上
		if (l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}
		return newHead.next;
	}

	//多个链表的合并
	static ListNode mergeManyLists(List<ListNode> lists) {
		if (lists == null) {
			return null;
		}
		if (lists.size() < 2) {
			return lists.get(0);
		}
		ListNode merged = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			ListNode tobeMerged = lists.get(i);
			merged = mergeTwoLists2(merged, tobeMerged);
		}
		return merged;
	}
}
