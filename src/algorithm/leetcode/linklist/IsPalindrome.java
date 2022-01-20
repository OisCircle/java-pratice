package algorithm.leetcode.linklist;

/**
 * @author qiuchengquan
 * @since 2021/7/10
 */
public class IsPalindrome {

	private static ListNode COMPARE = null;
	public static boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null) return true;
		ListNode slow=head,fast=head,rec;
		COMPARE=head;
		boolean[] res=new boolean[]{true};
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		//先一快一慢找出中间节点，也就是递归入口节点
		rec= fast==null?slow:slow.next;
		doRec(rec,res);
		return res[0];
	}

	private static void doRec(ListNode rec,boolean[] res){
		if(rec.next!=null){
			//递归到最后一个节点
			doRec(rec.next,res);
		}
		//从最后一个节点往前，和首节点逐一对比
		res[0]= res[0] && COMPARE.val == rec.val;
		COMPARE = COMPARE.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);


		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println(isPalindrome(n1));
	}
}
