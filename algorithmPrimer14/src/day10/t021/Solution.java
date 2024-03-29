package algorithmPrimer14.src.day10.t021;

/**
 * @author liq
 * @date 2021/7/26 17:43
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        result.next = l1;
        ListNode node = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return result.next;
    }
}
