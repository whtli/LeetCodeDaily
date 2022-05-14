package tecent50.src.ts160;

/**
 * @Description 160.相交链表
 * 给定两个单链表的头节点 headA 和 headB ，找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * @Author liq
 * @Date 2022/05/08
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = 0;
        int blen = 0;
        ListNode p = headA;
        while (p != null) {
            alen++;
            p = p.next;
        }
        ListNode q = headB;
        while (q != null) {
            blen++;
            q = q.next;
        }
        ListNode res = null;
        if (alen > blen) {
            res = getTarget(alen - blen, blen, headA, headB);
        } else {
            res = getTarget(blen - alen, alen, headB, headA);
        }
        return res;
    }

    public ListNode getTarget(int sub, int shorter, ListNode p, ListNode q) {
        for (int i = 0; i < sub; i++) {
            p = p.next;
        }
        for (int i = 0; i < shorter; i++) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}