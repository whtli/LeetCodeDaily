package it160.getIntersectionNode;

/**
 * @author : flower48237
 * @2020/3/27 9:52
 * @title : LeetCode精选TOP面试题160.相交链表
 */

public class Main {
    public static void main(String[] args) {
        ListNode l1 = CreateList(8, 4);
        ListNode l2 = CreateList(8, 3);
        ListNode p = l1;
        while (p != null){
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
        p = l2;
        while (p != null){
            System.out.print(p.val);
            p = p.next;
        }
        Solution solution = new Solution();
        System.out.println(solution.getIntersectionNode(l1, l2).val);

    }
    public static ListNode CreateList(int n, int m){
        ListNode list = new ListNode(0);
        ListNode tail = list;
        for (int i = n - m; i <= n; i ++){
            ListNode p = new ListNode(i);
            tail.next = p;
            tail = tail.next;
        }
        return list.next;
    }
}
