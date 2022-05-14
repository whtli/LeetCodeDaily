package tecent50.src.ts206;

/**
 * @Description 206. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表。
 * @Author liq
 * @Date 2022/05/12
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        ListNode res1 = solution1.reverseList(head);
        ListNode p = res1;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        ListNode res2 = solution2.reverseList(res1);
        ListNode q = res2;
        while (q != null) {
            System.out.print(q.val + " ");
            q = q.next;
        }
    }
}
