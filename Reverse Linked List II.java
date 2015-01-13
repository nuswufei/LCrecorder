 public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode segPre = move(dummyNode, m - 1);
        ListNode segEnd = move(dummyNode, n);
        ListNode cur = segPre.next;
        while(cur != segEnd) {
            ListNode rawNext = cur.next;
            cur.next = segEnd.next;
            segEnd.next = cur;
            cur = rawNext;
        }
        segPre.next = segEnd;
        return dummyNode.next;
    }
    private ListNode move(ListNode cur, int n) {
        ListNode result = cur;
        for(int i = 0; i < n; ++i) result = result.next;
        return result;
    }
 }
