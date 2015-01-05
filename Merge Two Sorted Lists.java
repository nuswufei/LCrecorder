public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode it1 = l1;
        ListNode it2 = l2;
        while(it1 != null && it2 != null) {
            if(it1.val < it2.val) {
                cur.next = it1;
                cur = cur.next;
                it1 = it1.next;
            } else {
                cur.next = it2;
                cur = cur.next;
                it2 = it2.next;
            }
        }
        if(it1 == null) cur.next = it2;
        else cur.next = it1;
        return dummyNode.next;
    }
}
