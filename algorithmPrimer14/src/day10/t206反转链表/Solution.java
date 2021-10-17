package algorithmPrimer14.src.day10.t206反转链表;

import java.util.List;

/**
 * @author liq
 * @date 2021/7/26 17:44
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 头插法
        if (head == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = result.next;
            result.next = node;
        }
        return result.next;
    }
}
