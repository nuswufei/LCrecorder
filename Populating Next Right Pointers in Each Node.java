public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null) {
            TreeLinkNode cur = head;
            head = cur.left;
            while(cur != null) {
                TreeLinkNode next  = cur.next;
                if(cur.left != null) cur.left.next = cur.right;
                if(next != null && next.left != null) cur.right.next = next.left;
                cur = next;
            }
        }
    }
}
