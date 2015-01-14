public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return dfs(root, sum, 0);
    }
    boolean dfs(TreeNode root, int sum, int cur) {
        cur += root.val;
        if(root.left == null && root.right == null) return cur == sum ?  true : false;
        if(root.left != null && dfs(root.left, sum, cur)) return true;
        if(root.right != null && dfs(root.right, sum, cur)) return true;
        return false;
    }
}
