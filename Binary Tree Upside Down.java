public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
        root = stk.empty() ? null : stk.peek();
        while(!stk.empty()) {
            TreeNode cur = stk.pop();
            if(stk.empty()) {
                cur.left = null;
                cur.right = null;
            }
            else {
                TreeNode par = stk.peek();
                cur.left = par.right;
                cur.right = par;
            }
        }
        return root;
    }
}
