public class BSTIterator {
    Stack<TreeNode> stk = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stk.pop();
        TreeNode tn = cur.right;
        while(tn != null) {
            stk.push(tn);
            tn = tn.left;
        }
        return cur.val;
    }
}
