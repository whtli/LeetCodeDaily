package tecent50.src.ts061;

/**
 * @Description 61. 旋转链表
 * 给定一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Author liq
 * @Date 2022/06/05
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = solution.rotateRight(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
