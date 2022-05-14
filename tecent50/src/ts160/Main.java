package tecent50.src.ts160;


/**
 * @Description 160.相交链表
 * 给定两个单链表的头节点 headA 和 headB ，找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * @Author liq
 * @Date 2022/05/08
 */
public class Main {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(1);
        headA.next= headB;
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        ListNode res1 = solution1.getIntersectionNode(headA, headB);
        ListNode res2 = solution2.getIntersectionNode(headA, headB);
        System.out.println(res1);
        if (res1 != null) {
            System.out.println(res1.val);
        }
        System.out.println(res2);
        if (res2 != null) {
            System.out.println(res2.val);
        }
    }
}
