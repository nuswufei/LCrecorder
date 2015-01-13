public class Solution {
    public int maxDepth(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int depth = 0;
        if(root != null) queue.add(root);
        while(queue.size() != 0) {
            ++depth;
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return depth;
    }
}
