public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> lstk = new Stack<TreeNode>();
        Stack<TreeNode> rstk = new Stack<TreeNode>();
        lstk.push(root.left);
        rstk.push(root.right);
        while(!(lstk.empty() || rstk.empty())) {
            TreeNode l = lstk.pop();
            TreeNode r = rstk.pop();
            if(l == null && r == null) continue;
            if(l == null || r == null) return false;
            if(l.val != r.val) return false;
            lstk.push(l.left);
            lstk.push(l.right);
            rstk.push(r.right);
            rstk.push(r.left);
        }
        if(!lstk.empty() || !rstk.empty()) return false;
        return true;
    }
}
