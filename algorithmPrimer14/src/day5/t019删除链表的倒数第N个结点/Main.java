package day5.t019删除链表的倒数第N个结点;

/**
 * @author liq
 * @date 2021/7/21 16:02
 * @list 20天算法刷题计划
 * @name 019. 删除链表的倒数第 N 个结点
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = null;
        ListNode p = listNode;
        for (int i = 2; i < 2; i++) {
            ListNode temp = new ListNode();
            temp.val = i;
            temp.next = null;
            p.next = temp;
            p = temp;
        }

        ListNode q = listNode;
        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }
        System.out.println();

        Solution solution = new Solution();
        int k = 1;
        ListNode result = solution.removeNthFromEnd(listNode, k);

        ListNode t = result;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }
}
