public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        TreeNode cur = root;
        while(cur.left != null) {
            cur = cur.left;
            stk.push(cur);
        }
        while(!stk.empty()) {
            cur = stk.pop();
            result.add(cur.val);
            if(cur.right != null) {
                cur = cur.right;
                stk.push(cur);
                while(cur.left != null) {
                    cur = cur.left;
                    stk.push(cur);
                }
            }
        }
        return result;
    }
}
