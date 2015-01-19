public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = count(headA);
        int countB = count(headB);
        if(countA > countB) headA = moveN(headA, countA - countB);
        else headB = moveN(headB, countB - countA);
        while(headA != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    int count(ListNode head) {
        int count = 0;
        while(head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
    ListNode moveN(ListNode head, int n) {
        for(int i = 0; i < n; ++i) head = head.next;
        return head;
    }
}
