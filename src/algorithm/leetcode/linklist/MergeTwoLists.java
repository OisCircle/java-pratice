package algorithm.leetcode.linklist;

/**
 * @author qiuchengquan
 * @since 2021/7/11
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//pre节点是为了统一处理，简约代码，最后返回的是pre.next
		ListNode pre=new ListNode(-1),target=null,cur=pre;
		//规律：两个都不为空，说明有一大一小。任意一个为空，说明后面的数值都大于另一个，不用再走循环处理，直接cur.next=l1==null?l2:l1;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				target=l1;
				l1=l1.next;
			}else{
				target=l2;
				l2=l2.next;
			}
			cur.next=target;
			cur=cur.next;
		}
		cur.next=l1==null?l2:l1;
		return pre.next;
	}
}
