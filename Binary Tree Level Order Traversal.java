public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.add(root);
        while(treeQueue.size() != 0) {
            int size = treeQueue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = treeQueue.poll();
                level.add(cur.val);
                if(cur.left != null) treeQueue.add(cur.left);
                if(cur.right != null) treeQueue.add(cur.right);
            }
            result.add(level);
        }
        return result;
    }
}
