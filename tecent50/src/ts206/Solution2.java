package tecent50.src.ts206;

/**
 * @Description 206. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表。
 * @Author liq
 * @Date 2022/05/12
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        for (ListNode p = head; p != null; p = p.next){
            rev = new ListNode(p.val, rev);
        }
        return rev;
    }
}
