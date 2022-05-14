package tecent50.src.ts141;

/**
 * @Description 141.环形链表
 * 给定一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * @Author liq
 * @Date 2022/05/06
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (slow.next != null) {
                slow = slow.next.next;
            } else {
                return false;
            }
        }
        return false;
        /*
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
         */
    }
}
