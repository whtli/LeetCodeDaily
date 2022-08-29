package tecent50.src.ts061;

/**
 * @Description 61. 旋转链表
 * 给定一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Author liq
 * @Date 2022/06/05
 */
public class Solution2 {
    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        int len = 1;
        while (first.next != null) {
            len++;
            first = first.next;
        }
        if (k % len == 0) {
            return head;
        }
        // 使之闭合为环
        first.next = head;
        // 第二次遍历
        ListNode second = head;
        int cnt = 1;
        // 移动k个位置，其实就是以 第len - k % len个节点的后继节点 作为新链表的头节点，并使其与其之前的节点断开链接
        // 所以此处可以做减法来替代快慢指针的同步遍历，只需要遍历一次即可。
        k = len - k % len;

        while (cnt < k) {
            cnt++;
            second = second.next;
        }

        ListNode res = second.next;
        second.next = null;
        return res;
    }
}
