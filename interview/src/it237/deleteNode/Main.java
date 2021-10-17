package it237.deleteNode;

/**
 * @author : flower48237
 * @2020/2/28 15:06
 * @title : LeetCode精选TOP面试题237.删除链表中的结点
 */
public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode tail = list;
        for (int i = 1; i < 5; i++){
            ListNode p = new ListNode(i);
            tail.next = p;
            tail = tail.next;
        }
        tail = list;
        while (tail != null){
            System.out.print(tail.val + " ");
            tail = tail.next;
        }
        Solution solution = new Solution();
        solution.deleteNode(list);
        tail = list;
        while (tail != null){
            System.out.print(tail.val + " ");
            tail = tail.next;
        }

    }
}
