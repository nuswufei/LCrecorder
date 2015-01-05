public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            ++count;
            cur = cur.next;
        }
        cur = dummyNode;
        for(int i = 0; i < count - n; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyNode.next;
    }
}
