 public class Solution {
    public boolean isValidBST(TreeNode root) {
        Integer pre = null;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(root != null || !stk.empty()) {
            if(root != null) {
                while(root != null) {
                    stk.push(root);
                    root = root.left;
                }
            }
            else {
                root = stk.pop();
                if(pre == null) pre = root.val;
                else if(pre >= root.val) return false;
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
 }
