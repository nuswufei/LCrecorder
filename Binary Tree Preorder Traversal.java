public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(root != null || !stk.empty()) {
            if(root != null) {
                stk.push(root);
                result.add(root.val);
                root = root.left;
            }
            else {
                root = stk.pop().right;
            }
        }
        return result;
    }
}
