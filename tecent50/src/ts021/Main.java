package tecent50.src.ts021;

/**
 * @Description 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author liq
 * @Date 2022/05/03
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        ListNode res = solution.mergeTwoLists(head1, head2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
    }
}
