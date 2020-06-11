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
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	void print() {
		System.out.println("ListNode::print");
		System.out.print(val);
		ListNode temp = this;
		while (temp.next != null) {
			System.out.print(" -> " + temp.next.val);
			temp = temp.next;
		}
		System.out.println("\n");
	}

	@Override
	public String toString() {
		return "val: " + val;
	}
}
