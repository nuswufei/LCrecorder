public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        if(root != null) nodes.add(root);
        while(nodes.size() != 0) {
            List<Integer> level = new ArrayList<Integer>();
            int size = nodes.size();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = nodes.poll();
                level.add(cur.val);
                if(cur.left != null) nodes.add(cur.left);
                if(cur.right != null) nodes.add(cur.right);
            }
            result.addFirst(level);
        }
        return result;
    }
}
