package tecent50.src.ts160;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 160.相交链表
 * 给定两个单链表的头节点 headA 和 headB ，找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * @Author liq
 * @Date 2022/05/08
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,ListNode> map = new HashMap<ListNode,ListNode>();
        while (headA != null) {
            map.put(headA, headA.next);
            headA = headA.next;
        }
        while(headB != null){
            if (map.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
