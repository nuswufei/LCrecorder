public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode it = dummyNode;
        int count = 0;
        while(it.next != null) {
            ++count;
            it = it.next;
        }
        n = n % count;
        if(n == 0) return head;
        ListNode newTail = moveN(dummyNode, count - n);
        ListNode newHead = newTail.next;
        ListNode oldTail = moveN(dummyNode, count);
        dummyNode.next = newHead;
        oldTail.next = head;
        newTail.next = null;
        return dummyNode.next;
    }
    private ListNode moveN(ListNode head, int n) {
        ListNode result = head;
        for(int i = 0; i < n; ++i) result = result.next;
        return result;
    }
}
