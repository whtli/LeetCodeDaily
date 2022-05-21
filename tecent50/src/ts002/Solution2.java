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
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return loop(l1, l2, 0);
    }

    public ListNode loop(ListNode l1, ListNode l2, int jin) {
        if (l1 == null && l2 == null && jin == 0){
            return null;
        }
        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;
        int sum = n1 + n2 + jin;

        jin = sum / 10;
        sum %= 10;

        ListNode node = new ListNode(sum);
        node.next = loop(l1 != null ? l1.next : null, l2 != null ? l2.next : null, jin);
        return node;
    }
}
