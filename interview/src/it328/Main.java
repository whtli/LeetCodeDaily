package interview.src.it328;

/**
 * @Description 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 使用原地算法完成。空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * @Author liq
 * @Date 2022/01/06
 */
public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next = new ListNode(8);
        Solution solution = new Solution();
        ListNode res = solution.oddEvenList(list);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
