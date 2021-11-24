package algorithmPrimer14.src.day5.t019;

/**
 * @author liq
 * @date 2021/7/21 16:02
 * @list 20天算法刷题计划
 * @name 019. 删除链表的倒数第 N 个结点
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(0, head);
        ListNode pre = head;
        ListNode tail = virtual;

        for (int index = 0; index < n; index ++) {
            pre = pre.next;
        }

        while (pre != null) {
            pre = pre.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return virtual.next;
    }
}
