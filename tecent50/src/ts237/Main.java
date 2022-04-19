package tecent50.src.ts237;

/**
 * @Description 237.删除链表中的节点
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点不是末尾节点。
 * 链表中每个节点的值都是 唯一 的
 * @Author liq
 * @Date 2022/04/13
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = null;
        solution.deleteNode(node.next);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
