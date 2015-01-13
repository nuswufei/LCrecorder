public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode vio1 = null;
        TreeNode vio2 = null;
        TreeNode last = null;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null) {
            if(cur.left == null) {
                if(last == null) last = cur;
                else if(last.val >= cur.val && vio1 == null) {
                    vio1 = last;
                    vio2 = cur;
                }
                else if(last.val >= cur.val && vio1 != null) vio2 = cur;
                last = cur;
                cur = cur.right;
            }
            else {
                pre = cur.left;
                while(pre.right != null && pre.right != cur) pre = pre.right;
                if(pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                else if(pre.right == cur) {
                    if(last.val > cur.val && vio1 == null) {
                        vio1 = last;
                        vio2 = cur;
                    }
                    else if(last.val >= cur.val && vio1 != null) vio2 = cur;
                    last = cur;
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        int temp = vio1.val;
        vio1.val = vio2.val;
        vio2.val = temp;
    }
 }
