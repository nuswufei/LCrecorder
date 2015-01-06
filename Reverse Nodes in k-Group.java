public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode segHead = dummyNode;
        ListNode segEnd = moveK(segHead, k);
        while(segEnd != null) {
            ListNode cur = segHead.next;
            ListNode next = cur.next;
            while(cur != segEnd) {
                insertAfter(segEnd, cur);
                cur = next;
                next = cur.next;
            }
            segHead.next = segEnd;
            segHead = moveK(segHead, k);
            segEnd = moveK(segHead, k);
        }
        return dummyNode.next;
    }
    private void insertAfter(ListNode pre, ListNode insertNode) {
        ListNode temp = pre.next;
        pre.next = insertNode;
        insertNode.next = temp;
    }
    private ListNode moveK(ListNode ln, int k) {
        for(int i = 0; i < k; ++i) {
            if(ln == null) return null;
            ln = ln.next;
        }
        return ln;
    }
 }
