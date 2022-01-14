package interview.src.it237;

/**
 * @author : flower48237
 * @2020/2/28 15:06
 * @title : LeetCode��ѡTOP������237.ɾ�������еĽ��
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
