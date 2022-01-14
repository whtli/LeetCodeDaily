package interview.src.it328;

/**
 * @Description 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 使用原地算法完成。空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * @Author liq
 * @Date 2022/01/06
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null) {
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;

        }
        /*while (list1 != null){
            System.out.print(list1.val + " ");
            list1 = list1.next;
        }
        System.out.println();
        while (list2 != null){
            System.out.print(list2.val + " ");
            list2 = list2.next;
        }*/
        p.next = even;

        return odd;
    }
}
