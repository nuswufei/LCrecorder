public class Solution {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            ++count;
        }
        if(count < 3) return;
        ListNode postHead = moveN(head, count - 1 >> 1);
        cur = postHead.next;
        postHead.next = null;
        while(cur != null) {
            ListNode next  = cur.next;
            insertAfter(postHead, cur);
            cur = next;
        }
        ListNode post = postHead.next;
        postHead.next = null;
        ListNode pre = head;
        while(post != null) {
            ListNode postNext = post.next;
            insertAfter(pre, post);
            post = postNext;
            pre = pre.next.next;
        }
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
