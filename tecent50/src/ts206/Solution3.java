package tecent50.src.ts206;

/**
 * @Description 206. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表。
 * @Author liq
 * @Date 2022/05/12
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        return loop(head);
    }
    private ListNode loop(ListNode node){
        if (node.next == null){
            return node;
        }
        ListNode newList = loop(node.next);
        node.next.next = node;
        node.next = null;
        return newList;
    }
}
