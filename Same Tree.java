public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStk = new Stack<TreeNode>();
        Stack<TreeNode> qStk = new Stack<TreeNode>();
        pStk.push(p);
        qStk.push(q);
        while(!pStk.empty() && !qStk.empty()) {
            p = pStk.pop();
            q = qStk.pop();
            if(p == null && q == null) continue;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;
            pStk.push(p.left);
            pStk.push(p.right);
            qStk.push(q.left);
            qStk.push(q.right);
        }
        if(!pStk.empty() || !qStk.empty()) return false;
        return true;
    }
}
