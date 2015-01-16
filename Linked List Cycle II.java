public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != slow) {
            if(fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
