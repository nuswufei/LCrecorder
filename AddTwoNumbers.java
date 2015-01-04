public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        int pre = 0;
        while(!(l1 == null && l2 == null)) {
            int d1 = 0;
            if(l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            } 
            int d2 = 0;
            if(l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }
            int cur = d1 + d2 + pre;
            pre = cur > 9 ? 1 : 0;
            curNode.next = new ListNode(cur % 10);
            curNode = curNode.next;
        }
        if(pre == 1) curNode.next = new ListNode(1);
        return dummyHead.next;
    }
}
