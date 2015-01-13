public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<List<List<TreeNode>>> dpt = new ArrayList<List<List<TreeNode>>>();
        for(int start = 0; start < n + 1; ++start) {
            List<List<TreeNode>> startList = new ArrayList<List<TreeNode>>();
            List<TreeNode> nullList = new ArrayList<TreeNode>();
            nullList.add(null);
            startList.add(nullList);
            List<TreeNode> oneNumList = new ArrayList<TreeNode>();
            oneNumList.add(new TreeNode(start + 1));
            startList.add(oneNumList);
            dpt.add(startList);
        }
        for(int length = 2; length <= n; ++length) {
            for(int start = 0; start < n - length + 1; ++start) {
                List<TreeNode> result = new ArrayList<TreeNode>();
                for(int i = start; i < start + length; ++i) {
                    for(TreeNode left : dpt.get(start).get(i - start)) {
                        for(TreeNode right : dpt.get(i + 1).get(length - i + start - 1)) {
                            TreeNode root = new TreeNode(i + 1);
                            root.left = left;
                            root.right = right;
                            result.add(root);
                        }
                    }
                }
                dpt.get(start).add(result);
            }
        }
        return dpt.get(0).get(n);
    }
}
