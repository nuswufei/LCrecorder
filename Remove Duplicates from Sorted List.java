public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode last = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == last.val) {
                last.next = cur.next;
            }
            else {
                last = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
