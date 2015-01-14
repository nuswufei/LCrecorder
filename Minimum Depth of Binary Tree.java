public class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        if(root != null) nodes.add(root);
        int depth = 0;
        while(nodes.size() != 0) {
            ++depth;
            int size = nodes.size();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = nodes.poll();
                if(cur.left == null & cur.right == null) return depth;
                if(cur.left != null) nodes.add(cur.left);
                if(cur.right != null) nodes.add(cur.right);
            }
        }
        return depth;
    }
 }
