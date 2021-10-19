package interview.src.it234;

import java.util.Stack;

/**
 * @Description 234.回文链表
 * 给定一个单链表的头节点 head ，判断该链表是否为回文链表。
 * 若是，返回 true ；否则，返回 false 。
 * @Author liq
 * @Date 2021/10/19
 */
public class Solution3 {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        Stack<Integer> stack = new Stack<>();

        p = head;
        for (int i = 0; i < length / 2; i++) {
            stack.push(p.val);
            p = p.next;
        }

        if (length % 2 != 0) {
            p = p.next;
        }
        for (int i = 0; i < length / 2 && p != null; i++) {
            if (stack.pop() != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
