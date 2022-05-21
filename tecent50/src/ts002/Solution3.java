package tecent50.src.ts002;

import java.math.BigInteger;

/**
 * @Description 2. 两数相加
 * 给定两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请将两个数相加，并以相同形式返回一个表示和的链表。
 * 可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author liq
 * @Date 2022/05/21
 */
public class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder m = new StringBuilder();
        StringBuilder n = new StringBuilder();
        while (l1 != null) {
            m.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            n.append(l2.val);
            l2 = l2.next;
        }
        BigInteger mm = new BigInteger(m.reverse().toString());
        BigInteger nn = new BigInteger(n.reverse().toString());
        BigInteger res = mm.add(nn);

        StringBuilder s = new StringBuilder(res.toString());

        ListNode list = new ListNode(0);
        ListNode r = list;
        for (int i = s.length() - 1; i >= 0; i--){
            r.next = new ListNode(s.charAt(i) - '0');
            r = r.next;
        }
        return list.next;
    }
}
