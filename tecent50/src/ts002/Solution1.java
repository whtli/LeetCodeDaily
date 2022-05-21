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
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jin = 0;
        int sum = 0;
        ListNode list = new ListNode(0);
        ListNode r = list;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + jin;
            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + jin;
            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + jin;
            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;
            l2 = l2.next;
        }
        if (jin == 1) {
            r.next = new ListNode(1);
        }
        return list.next;
    }

    // 以下代码是上方代码的简化版
    public ListNode addTwoNumbersSim(ListNode l1, ListNode l2) {
        int jin = 0;
        ListNode list = new ListNode(0);
        ListNode r = list;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + jin;

            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (jin == 1) {
            r.next = new ListNode(1);
        }
        return list.next;
    }
}
