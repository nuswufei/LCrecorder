public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> oneSol = new ArrayList<Integer>();
        dfs(result, oneSol, 0, num, true);
        return result;
    }
    private void dfs(List<List<Integer>> result, ArrayList<Integer> oneSol, int curIndex, int[] num, boolean lastAdded) {
        if(curIndex == num.length) {
            result.add(oneSol);
            return;
        }
        ArrayList<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
        dfs(result,oneSolCopy, curIndex + 1, num, false);
        if(lastAdded || num[curIndex] != num[curIndex - 1]) {
            oneSolCopy = new ArrayList<Integer>(oneSol);
            oneSolCopy.add(num[curIndex]);
            dfs(result,oneSolCopy, curIndex + 1, num, true);
        }
    }
}
