public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] result = new int[1];
        dfs(root, 0, result);
        return result[0];
    }
    void dfs(TreeNode root, int cur, int[] result) {
        int value = cur * 10 + root.val;
        if(root.left == null && root.right == null) {
            result[0] += value;
            return;
        }
        if(root.left != null) {
            dfs(root.left, value, result);
        }
        if(root.right != null) {
            dfs(root.right, value, result);
        }
    }
}
