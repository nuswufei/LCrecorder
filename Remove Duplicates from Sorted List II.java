public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode segStart = dummyNode;
        ListNode segEnd = dummyNode.next;
        while(segEnd != null) {
            if(segEnd.next != null  && segEnd.val == segEnd.next.val) {
                while(segEnd.next != null  && segEnd.val == segEnd.next.val) {
                    segEnd = segEnd.next;
                }
                segStart.next = segEnd.next;
            }
            else {
                segStart = segEnd;
            }
            segEnd = segEnd.next;
        }
        return dummyNode.next;
    }
 }
