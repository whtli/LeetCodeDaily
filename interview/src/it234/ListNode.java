package interview.src.it234;

/**
 * @Description 234.回文链表
 * 给定一个单链表的头节点 head ，判断该链表是否为回文链表。
 * 若是，返回 true ；否则，返回 false 。
 * @Author liq
 * @Date 2021/10/19
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
