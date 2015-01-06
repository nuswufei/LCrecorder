public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next != null && cur.next.next != null) {
            ListNode post = cur.next.next.next;
            ListNode next = cur.next;
            cur.next = cur.next.next;
            cur.next.next = next;
            cur.next.next.next = post;
            cur = cur.next.next;
        }
        return dummyNode.next;
    }
}
