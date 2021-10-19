package interview.src.it234;

/**
 * @Description 234.回文链表
 * 给定一个单链表的头节点 head ，判断该链表是否为回文链表。
 * 若是，返回 true ；否则，返回 false 。
 * @Author liq
 * @Date 2021/10/19
 */
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        // 改变后半部分节点，头插法
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < length / 2; i++) {
            p = p.next;
        }
        if (length % 2 != 0) {
            p = p.next;
        }
        ListNode q = p;
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        for (int i = 0; i < length / 2 && p != null; i++) {
            p = p.next;
            q.next = newHead;
            newHead = q;
            q = p;
        }
        for (int j = 0; j < length / 2; j++) {
            if (newHead.val != head.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
