 public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    TreeNode getTree(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if(il > ir) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int rootPosition = -1;
        for(int i = il; i <= ir; ++i) {
            if(inorder[i] == root.val) {
                rootPosition = i;
                break;
            }
        }
        int leftLength = rootPosition - il;
        root.left = getTree(inorder, postorder, il, rootPosition - 1, pl, pl + leftLength - 1);
        root.right = getTree(inorder, postorder, rootPosition + 1, ir, pl + leftLength, pr - 1);
        return root;
    }
 }
