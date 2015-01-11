public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; ++i) nums.add(i);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> oneSol = new ArrayList<Integer>();
        if(k > n) return result;
        dfs(result, oneSol, k, nums);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> oneSol, int k, List<Integer> nums) {
        if(k == 0) {
            result.add(oneSol);
            return;
        }
        for(int i = 0; i <= nums.size() - k; ++i) {
            List<Integer> numsCopy = new ArrayList<Integer>(nums);
            List<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
            oneSolCopy.add(nums.get(i));
            for(int j = 0; j < i + 1; ++j) numsCopy.remove(0);
            dfs(result, oneSolCopy, k - 1, numsCopy);
        }
    }
}
