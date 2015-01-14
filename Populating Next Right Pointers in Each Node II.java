public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(root != null) {
            TreeLinkNode cur = root;
            root = root.left;
            TreeLinkNode last  = root;
            while(cur != null) {
                if(cur.left != null && root == null) {
                    root = cur.left;
                    last = cur.left;
                }
                else if(cur.left != null && root != null && root != cur.left) {
                    last.next = cur.left;
                    last = cur.left;
                }
                if(cur.right != null && root == null) {
                    root = cur.right;
                    last = cur.right;
                }
                else if (cur.right != null && root != null) {
                    last.next = cur.right;
                    last = cur.right;
                }
                cur = cur.next;
            }
        }
    }
}
