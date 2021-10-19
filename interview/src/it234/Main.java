package interview.src.it234;

/**
 * @Description 234.回文链表
 * 给定一个单链表的头节点 head ，判断该链表是否为回文链表。
 * 若是，返回 true ；否则，返回 false 。
 * @Author liq
 * @Date 2021/10/19
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        ListNode p = head;

        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
        System.out.println("solution3 and solution2 will not change the structure of list, solution1 will change it.\n");
        System.out.println("==solution3=============");
        Solution3 solution3 = new Solution3();
        boolean result3 = solution3.isPalindrome(head.next);
        System.out.println("result3 : " + result3);
        System.out.println("==after solution3=======");
        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
        /**
         * solution 2 和 solution 3 不能同时调用
         * 因为使用其中一个后会改变链表结构。
         */
        System.out.println("\n==solution2=============");
        Solution2 solution2 = new Solution2();
        boolean result2 = solution2.isPalindrome(head.next);
        System.out.println("result2 : " + result2);
        System.out.println("==after solution2=======");
        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);

        System.out.println("\n==solution1=============");
        Solution1 solution1 = new Solution1();
        boolean result1 = solution1.isPalindrome(head.next);
        System.out.println("result1 : " + result1);
        System.out.println("==after solution1=======");
        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
    }
}
