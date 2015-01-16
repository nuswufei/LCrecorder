public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode resultHead = head.next;
        while(cur != null) {
            RandomListNode next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            if(cur != null) next.next = cur.next;
        }
        return resultHead;
    }
}
