public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            ++count;
            cur = cur.next;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        for(int i = count - 2; i >= 0; --i) {
            head = moveN(dummyNode, i);
            cur = head.next;
            ListNode it = cur.next;
            if(cur.val <= it.val) continue;
            head.next = it;
            while(!(cur.val > it.val && (it.next == null || it.next.val >= cur.val))) {
                it = it.next;
            }
            insertAfter(it, cur);
        }
        return dummyNode.next;
    }
    ListNode moveN(ListNode head, int n) {
        for(int i = 0; i < n; ++i) head = head.next;
        return head;
    }
    void insertAfter(ListNode head, ListNode node) {
        node.next = head.next;
        head.next = node;
    }
}
