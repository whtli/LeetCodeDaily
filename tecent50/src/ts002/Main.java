package tecent50.src.ts002;

/**
 * @Description 2. 两数相加
 * 给定两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请将两个数相加，并以相同形式返回一个表示和的链表。
 * 可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author liq
 * @Date 2022/05/21
 */
public class Main {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);


        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(1);
        l6.next = new ListNode(9);
        l6.next.next = new ListNode(9);
        l6.next.next.next = new ListNode(9);
        l6.next.next.next.next = new ListNode(9);
        l6.next.next.next.next.next = new ListNode(9);
        l6.next.next.next.next.next.next = new ListNode(9);
        l6.next.next.next.next.next.next.next = new ListNode(9);
        l6.next.next.next.next.next.next.next .next = new ListNode(9);
        l6.next.next.next.next.next.next.next.next.next = new ListNode(9);

        Solution2 solution = new Solution2();
        ListNode l = solution.addTwoNumbers(l5, l6);
        System.out.println("----------------");
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
