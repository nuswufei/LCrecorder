/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        int curnum = 0;
        TreeNode cur = root;
        while(cur != null || !stk.isEmpty()) {
            while(cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            if(++curnum == k) return cur.val;
            cur = cur.right;
        }
        return 0;
    }
}
