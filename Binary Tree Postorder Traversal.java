public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(root != null || !stk.empty()) {
            if(root != null) {
                stk.push(root);
                root = root.left;
            }
            else {
                root = stk.peek();
                if(root.right == null || (result.size() != 0 && root.right == result.get(result.size() - 1))) {
                    stk.pop();
                    result.add(root);
                    root = null;
                }
                else {
                    root = root.right;
                }
            }
        }
        List<Integer> lst = new ArrayList<Integer>();
        for(TreeNode t : result) lst.add(t.val);
        return lst;
    }
}
