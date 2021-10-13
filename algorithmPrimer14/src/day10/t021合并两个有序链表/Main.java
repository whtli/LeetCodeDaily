package day10.t021合并两个有序链表;

/**
 * @author liq
 * @date 2021/7/26 17:43
 * @list 20天算法刷题计划
 * @name
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        l1 = solution.mergeTwoLists(l1, l2);

        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
