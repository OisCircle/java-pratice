package algorithm.leetcode.linklist;

/**
 * @author qiuchengquan
 * @since 2021/7/10
 */
public class IsPalindrome2 {

	private static ListNode COMPARE = null;
	public static boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null) return true;
		COMPARE=head;
		//第一个节点代表返回值，第二个节点代表是否应该继续递归的计算
		boolean[] flag=new boolean[]{true,true};
		doRec(head, flag);
		return flag[0];
	}
	private static void doRec(ListNode cur,boolean[] flag){
		if(cur.next!=null){
			//递归到最后一个节点
			doRec(cur.next,flag);
		}
		//地址相等说明节点相撞了，不需要再进行对比了
		if(COMPARE==cur)flag[1]=false;
		if(flag[1]){
			//从后往前对比val
			flag[0]= flag[0] && COMPARE.val == cur.val;
			COMPARE = COMPARE.next;
		}
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
