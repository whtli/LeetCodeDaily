package interview.src.it160;

import sun.nio.cs.ext.MacArabic;

/**
 * @Description
 * @Author liq
 * @Date
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;

        ListNode p = headA;
        while (p != null){
            lenA ++;
            p = p.next;
        }
        p = headB;
        while (p != null){
            lenB++;
            p = p.next;
        }
        if (lenA < lenB){
            for (int i = 0; i < lenB - lenA; i ++){
                headB = headB.next;
            }
            while (headA != null && headB != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }else {
            for (int i = 0; i < lenA - lenB; i ++){
                headA = headA.next;
            }
            while (headA != null && headB != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
