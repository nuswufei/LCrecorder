public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = {Integer.MIN_VALUE};
        if(root == null) return 0;
        maxPath(root, result);
        return result[0];
    }
    int maxPath(TreeNode root, int[] result) {
        if(root.left == null && root.right == null) {
            result[0] = Math.max(result[0], root.val);
            return Math.max(root.val, 0);
        }
        int leftMax = 0;
        int rightMax = 0;
        if(root.left != null) leftMax = maxPath(root.left, result);
        if(root.right != null) rightMax = maxPath(root.right, result);
        result[0] = Math.max(result[0], root.val + leftMax + rightMax);
        return maxOfThree(root.val + leftMax, root.val + rightMax, 0);
    }
    int maxOfThree(int i1, int i2, int i3) {
        return Math.max(Math.max(i1, i2), i3);
    }
 }
