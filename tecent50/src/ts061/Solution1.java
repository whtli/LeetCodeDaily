package tecent50.src.ts061;

/**
 * @Description 61. 旋转链表
 * 给定一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Author liq
 * @Date 2022/06/05
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode iter = head;
        int len = 0;
        ListNode tail = null;
        while (iter != null) {
            if (iter.next == null) {
                tail = iter;
            }
            len++;
            iter = iter.next;
        }
        // 如果移动次数恰好是链表长度的倍数，说明移动后也是原样，所以不需要移动
        if (k % len == 0) {
            return head;
        }
        // 初始令计数器延后一位（即-1），以获取结果链表的起始位置的前一个位置
        // 此处若初始令计数器为0，则获得的是结果链表的其实位置，无法将它与之前的节点断开
        int cnt = -1;
        // 先把k简化，再令快指针向前遍历k步
        ListNode fast = head;
        k = k % len;
        while (cnt != k) {
            cnt++;
            fast = fast.next;
        }
        // 再同步开启慢指针的遍历
        // 当快指针为空时，说明慢指针已经到达了目标结果链表的起始节点的前一个位置
        ListNode second = head;
        while (fast != null) {
            fast = fast.next;
            second = second.next;
        }
        // 使原始链表闭合为环
        tail.next = head;
        // 获得新起点
        ListNode res = second.next;
        // 从新起点之前断开
        second.next = null;
        // 返回结果
        return res;
    }
}
