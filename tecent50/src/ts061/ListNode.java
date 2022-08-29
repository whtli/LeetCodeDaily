package tecent50.src.ts061;

/**
 * @Description 61. 旋转链表
 * 给定一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Author liq
 * @Date 2022/06/05
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