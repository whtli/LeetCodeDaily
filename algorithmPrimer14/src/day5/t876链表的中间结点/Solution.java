package algorithmPrimer14.src.day5.t876链表的中间结点;

/**
 * @author liq
 * @date 2021/7/21 16:02
 * @list 20天算法刷题计划
 * @name 876. 链表的中间结点
 * @note 循环的判定条件需要注意
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
