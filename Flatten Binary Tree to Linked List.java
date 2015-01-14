public class Solution {
    public void flatten(TreeNode root) {
        if(root != null) convert(root);
    }
    List<TreeNode> convert(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        result.add(root);
        TreeNode right = root.right;
        TreeNode tail = root;
        if(root.left != null) {
            List<TreeNode> leftList = convert(root.left);
            root.right = leftList.get(0);
            tail = leftList.get(1);
        }
        root.left = null;
        if(right != null) {
            List<TreeNode> rightList = convert(right);
            tail.right = rightList.get(0);
            tail = rightList.get(1);
        }
        result.add(tail);
        return result;
    }
}
