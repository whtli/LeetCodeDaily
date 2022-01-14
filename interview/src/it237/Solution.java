package interview.src.it237;
/**
 * @Description
 * @Author liq
 * @Date
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode latter = node.next;
        node.val = latter.val;
        node.next = latter.next;
        latter.next = null;
    }
}
