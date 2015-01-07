class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> oneSol = new ArrayList<Integer>();
        dfs(candidates, target, oneSol, result);
        return result;
    }
    private void dfs(int[] candidates, int target, List<Integer> oneSol, List<List<Integer>> result) {
        if(target == 0) {
            result.add(oneSol);
            return;
        }
        int lastNum = oneSol.size() == 0 ? 0 : oneSol.get(oneSol.size() - 1);
        for(int num : candidates) {
            if(num >= lastNum && num <= target) {
                List<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
                oneSolCopy.add(num);
                dfs(candidates, target - num, oneSolCopy, result);
            }
        }
    }
}
