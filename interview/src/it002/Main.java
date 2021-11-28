package interview.src.it002;
/**
 * Demo class
 *
 * @author liq155
 * @date 2021/06/11
 */
public class Main {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode p = l1;
		for (int i = 0; i < 9; i++) {
			ListNode q = new ListNode(9);
			p.next = q;
			p = p.next;
		}
		p = l1;
		while(p !=null){
            System.out.print(p.val + " ");
            p = p.next;
        }
		ListNode l2 = new ListNode(9);
		System.out.println();
		
		p = l2;
		while(p !=null){
            System.out.print(p.val + " ");
            p = p.next;
        }
		System.out.println();
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers(l1, l2);
		while(result !=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
	}
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int item = 0;
    	int flag = 0;
    	ListNode res = new ListNode(0);
        ListNode q = res;
    	while(l1 !=null || l2 != null){
    		if(l1 !=null && l2 !=null) {
    			item = l1.val + l2.val;
    		}
    		else if (l1 !=null && l2 ==null ) {
    			item = l1.val;
    		}
    		else if (l1 ==null && l2 !=null ) {
    			item = l2.val;
    		}
            
            if (flag == 1) {
            	item += 1;
            	flag = 0;
            }
            if (item >= 10) {
            	flag = 1;
            	item = item % 10;
            }
            ListNode p = new ListNode(item);
            q.next = p;
            q = q.next;
            if(l1 !=null) {
            	l1 = l1.next;
    		}
    		if (l2 !=null) {
    			l2 = l2.next;
    		}
        }
    	if (flag == 1) {
    		ListNode p = new ListNode(1);
    		q.next = p;
    		q = q.next;
    	}
    	/*if(l1 !=null) {
//    		System.out.print(l1.val + " ");
    		q.next = l1;
    		l1 = l1.next;
    	}
    	if(l2 !=null) {
//    		System.out.print(l2.val + " ");
    		q.next = l2;
    		l2 = l2.next;	
    	}*/
    	if(q != res){
            q = res;
            res = res.next;
            q = null;
        }
    	/*long i = 1, j = 1;
        long add1 = 0, add2 = 0;
        while(l1 !=null){
            add1 += i * l1.val;
            l1 = l1.next;
            i *= 10;
        }
        System.out.println(add1);
        while(l2 !=null){
            add2 += j * l2.val;
            l2 = l2.next;
            j *= 10;
        }
        System.out.println(add2);
        long sum = add1 + add2;
        System.out.println(sum);
        // 尾插法
        ListNode res = new ListNode((int) (sum % 10));
        ListNode q = res;
        while(sum != 0){
            ListNode p = new ListNode((int) (sum % 10));
            sum /= 10;
            q.next = p;
            q = q.next;
        }
        if(q != res){
            q = res;
            res = res.next;
            q = null;
        }*/
        
        return res;
    }
}