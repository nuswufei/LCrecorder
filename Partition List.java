public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;
        while(head != null) {
            ListNode rawNext = head.next;
            if(head.val < x) {
                insertAfter(smallTail, head);
                smallTail = smallTail.next;
            }
            else {
                insertAfter(bigTail, head);
                bigTail = bigTail.next;
            }
            head = rawNext;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
    private void insertAfter(ListNode head, ListNode newNode) {
        newNode.next = head.next;
        head.next = newNode;
    }
 }
