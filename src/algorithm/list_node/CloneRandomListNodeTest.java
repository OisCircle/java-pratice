package algorithm.list_node;

/**
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/16
 */
public class CloneRandomListNodeTest {
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n1.random = n3;
		n2.random = n5;
		n3.random = null;
		n4.random = n2;
		n5.random = null;

		print(n1);
		System.out.println();
		System.out.println();
		System.out.println();

		print(clone(n1));
	}

	private static void print(RandomListNode node) {
		while (node != null) {
			System.out.println(node.label);
			if (node.random != null) {
				System.out.println(node.random.label);
			}
			System.out.println("---");
			node = node.next;
		}
	}

	static RandomListNode clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		RandomListNode node = pHead;
		//1->2->3经过第一个循环之后1->1->2->2->3->3
		while (node != null) {
			RandomListNode newNode = new RandomListNode(node.label);
			RandomListNode next = node.next;
			node.next = newNode;
			newNode.next = next;
			node = next;
		}
		//复制每个节点的random
		node = pHead;
		while (node != null) {
			if (node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		//提取链表
		//注意!这里是牛客网的那道题目,在提取链表之后还要保证原链表的完整性
		RandomListNode newNode = pHead.next;
		RandomListNode oldNode = pHead;
		RandomListNode cur = pHead.next;
		while (cur != null) {
			oldNode.next = cur.next;
			if (cur.next != null) {
				oldNode = cur.next;
				cur.next = cur.next.next;
				cur = cur.next;
			} else {
				cur = null;
			}
		}
		return newNode;
	}
}
