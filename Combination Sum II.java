public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> oneSol = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num, target, oneSol, result);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for(List<Integer> indexLst : result) {
            List<Integer> numLst = new ArrayList<Integer>();
            for(int i : indexLst) {
                numLst.add(num[i]);
            }
            resultList.add(numLst);
        }
        return resultList;
    }
    private void dfs(int[] candidates, int target, List<Integer> oneSol, List<List<Integer>> result) {
        if(target == 0) {
            result.add(oneSol);
            return;
        }
        int lastNumIndex = oneSol.size() == 0 ? -1 : oneSol.get(oneSol.size() - 1);
        for(int i = lastNumIndex + 1; i < candidates.length; ++i) {
            if((i == lastNumIndex + 1 || candidates[i] != candidates[i - 1]) && candidates[i] <= target) {
                List<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
                oneSolCopy.add(i);
                dfs(candidates, target - candidates[i], oneSolCopy, result);
            }
        }
    }
}
