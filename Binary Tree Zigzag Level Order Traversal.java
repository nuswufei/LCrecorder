public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        if(root != null) stk.push(root);
        int indicator = 1;
        while(!stk.empty()) {
            List<Integer> level = new ArrayList<Integer>();
            Stack<TreeNode> nextStk = new Stack<TreeNode>();
            int size = stk.size();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = stk.pop();
                level.add(cur.val);
                if(indicator == 1) {
                    if(cur.left != null) nextStk.push(cur.left);
                    if(cur.right != null) nextStk.push(cur.right);
                }
                else {
                    if(cur.right != null) nextStk.push(cur.right);
                    if(cur.left != null) nextStk.push(cur.left);
                }
            }
            stk = nextStk;
            result.add(level);
            indicator ^= 1;
        }
        return result;
    }
 }
