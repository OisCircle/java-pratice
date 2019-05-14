package algorithm.list_node;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/9
 */
public class HasCircleListNodeTest {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(4);

		head.next = l2;
//		l2.next = head;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = head;

		System.out.println(hasCycle(head));

	}

	static boolean hasCycle(ListNode head) {
		//1.一快一慢找出环
		//2.一停一搜找出环长度（本题不要求这一步骤）
		//3.一个指针先走n步找出入口（本题不要求这一步骤）

		if (head == null) {
			return false;
		}
		if (head.next == head) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;

		do {
			slow = slow.next;
			if (fast == null) {
				return false;
			}
			fast = fast.next;
			if (fast == null) {
				return false;
			}
			fast = fast.next;
		} while (slow != fast);

		return true;
	}


}
