public class Solution {
	 public ListNode sortList(ListNode head) {
	     int length = 2;
	     ListNode dummy = new ListNode(0);
	     dummy.next = head;
	     ListNode counter = head;
	     int count = 0;
	     while(counter != null) {
	         ++count;
	         counter = counter.next;
	     }
	     while(length < count * 2) {
	         ListNode segHead = dummy;
	         while(segHead.next != null) {
	             ListNode seg1 = segHead.next;
	             ListNode seg2 = moveN(segHead, length >> 1);
	             ListNode temp = moveN(seg2, 1);
	             if(temp == null) break;
	             seg2.next = null;
	             seg2 = temp;
	             ListNode segTail = moveN(seg2, (length >> 1) - 1);
	             temp = moveN(segTail, 1);
	             if(segTail != null) segTail.next = null;
	             segTail = temp;
	             segHead.next = segTail;
	             ListNode nextSegHead = segHead;
	             ListNode rawNext = null;
	             while(seg1 != null || seg2 != null) {
	            	 if(seg2 == null || (seg1 != null && seg1.val <= seg2.val)) {
	            		 rawNext = seg1.next;
	            		 insertAfter(nextSegHead, seg1);
	            		 nextSegHead = seg1;
	            		 seg1 = rawNext;
	            	 }
	            	 else {
	            		 rawNext = seg2.next;
	            		 insertAfter(nextSegHead, seg2);
	            		 nextSegHead = seg2;
	            		 seg2 = rawNext;
	            	 }
	             }
	             segHead = nextSegHead;
	         }
	        length *= 2;
	     }
	     return dummy.next;
	 }
	 ListNode moveN(ListNode head, int n) {
	     for(int i = 0; i < n; ++i) {
	         if(head == null) return null;
	         head = head.next;
	     }
	     return head;
	 }
	 void insertAfter(ListNode pre, ListNode post) {
	     post.next = pre.next;
	     pre.next = post;
	 }
}
