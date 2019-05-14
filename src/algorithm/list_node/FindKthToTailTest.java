package algorithm.list_node;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class FindKthToTailTest {
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

		System.out.println(findKthToTail(n1, 1).val);
		System.out.println(findKthToTail(n1, 2).val);
		System.out.println(findKthToTail(n1, 3).val);
		System.out.println(findKthToTail(n1, 4).val);
		System.out.println(findKthToTail(n1, 5).val);
		System.out.println(findKthToTail(n1, 6).val);
	}

	static ListNode findKthToTail(ListNode head, int k) {
		if (k < 1) {
			System.out.println("倒数第" + k + "个不存在!");
			return null;
		}
		ListNode pre = head;
		ListNode node = head;
		for (int i = 0; i < k; i++) {
			if (pre == null) {
				System.out.println("倒数第" + k + "个不存在!");
				return null;
			}
			pre = pre.next;
		}
		while (pre != null) {
			node = node.next;
			pre = pre.next;
		}
		return node;
	}
}
