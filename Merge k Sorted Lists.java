public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0) return null;
        while(lists.size() > 1) {
            int curSize = lists.size();
            for(int i = 0; i < curSize >> 1; ++i) {
                lists.add(mergeTwoLists(lists.get(0), lists.get(1)));
                lists.remove(0);
                lists.remove(0);
            }
        }
        return lists.get(0);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
