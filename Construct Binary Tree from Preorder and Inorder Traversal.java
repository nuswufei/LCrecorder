public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    TreeNode getTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int rootPosition = -1;
        for(int i = il; i <= ir; ++i) {
            if(inorder[i] == root.val) {
                rootPosition = i;
                break;
            }
        }
        int leftLength = rootPosition - il;
        root.left = getTree(preorder, inorder, pl + 1, pl + leftLength, il, rootPosition - 1);
        root.right = getTree(preorder, inorder, pl + leftLength + 1, pr, rootPosition + 1, ir);
        return root;
    }
 }
