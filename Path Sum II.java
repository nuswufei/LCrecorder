public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> oneSol = new ArrayList<Integer>();
        dfs(result, oneSol, root, sum, 0);
        return result;
    }
    void dfs(List<List<Integer>> result, List<Integer> oneSol, TreeNode root, int sum, int cur) {
        cur += root.val;
        oneSol.add(root.val);
        if(root.left == null && root.right == null) {
            if(cur == sum) result.add(oneSol);
            return;
        }
        if(root.left != null) {
            List<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
            dfs(result, oneSolCopy, root.left, sum, cur);
        }
        if(root.right != null) {
            List<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
            dfs(result, oneSolCopy, root.right, sum, cur);
        }
    }
}
