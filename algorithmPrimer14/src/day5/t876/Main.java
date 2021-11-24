package algorithmPrimer14.src.day5.t876;

/**
 * @author liq
 * @date 2021/7/21 16:02
 * @list 20天算法刷题计划
 * @name 876. 链表的中间结点
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = null;
        ListNode p = listNode;
        for (int i = 2; i <= 6; i++) {
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

        Solution solution = new Solution();
        ListNode result = solution.middleNode(listNode);

        ListNode t = result;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }
}
