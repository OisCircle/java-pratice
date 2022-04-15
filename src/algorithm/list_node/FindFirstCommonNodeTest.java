package algorithm.list_node;

/**
 * <p>
 * https://www.cnblogs.com/liulongtao/p/13955929.html
 *
 * 指针交换法更加容易实现
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/18
 */
public class FindFirstCommonNodeTest {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n7.next = n4;
		System.out.println(findFirstCommonNode(n1, n7).val);
	}


	static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode a = pHead1, b = pHead2;
		int lenA = 0, lenB = 0, gap;
		if (a == null || b == null) {
			return null;
		}
		while (a != null) {
			lenA++;
			a = a.next;
		}
		while (b != null) {
			lenB++;
			b = b.next;
		}
		a = pHead1;
		b = pHead2;
		if (lenA < lenB) {
			gap = lenB - lenA;
			while (gap-- > 0) {
				b = b.next;
			}
		} else if (lenA > lenB) {
			gap = lenA - lenB;
			while (gap-- > 0) {
				a = a.next;
			}
		} else {
			return pHead1;
		}
		while (a != b) {
			a = a.next;
			b = b.next;
		}
		return a;
	}

}
