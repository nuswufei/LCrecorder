public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            ++count;
            cur = cur.next;
        }
        int rootIndex = (count - 1) >> 1;
        ListNode rootNode = moveN(head, rootIndex);
        TreeNode root = new TreeNode(rootNode.val);
        ListNode leftEnd = moveN(dummyNode, rootIndex);
        leftEnd.next = null;
        root.left = sortedListToBST(dummyNode.next);
        root.right = sortedListToBST(rootNode.next);
        return root;
    }
    ListNode moveN(ListNode head, int n) {
        for(int i = 0; i < n; ++i) head = head.next;
        return head;
    }
 }
