public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return getTree(num, 0, num.length - 1);
    }
    TreeNode getTree(int[] num, int left, int right) {
        if(left > right) return null;
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = getTree(num, left, mid - 1);
        root.right = getTree(num, mid + 1, right);
        return root;
    }
}
