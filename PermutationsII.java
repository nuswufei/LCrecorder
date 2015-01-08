public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for(int i : num) {
            if(!dic.containsKey(i)) dic.put(i, 1);
            else dic.put(i, dic.get(i) + 1);
        }
        List<Integer> oneSol = new ArrayList<Integer>();
        dfs(result, dic, oneSol);
        return result;
    }
    private void dfs(List<List<Integer>> result, Map<Integer, Integer> dic, List<Integer> oneSol) {
        if(dic.isEmpty()) {
            result.add(oneSol);
            return;
        }
        for(Integer i : dic.keySet()) {
            Map<Integer, Integer> dicCopy = new HashMap<Integer, Integer>(dic);
            List<Integer> oneSolCopy = new ArrayList<Integer>(oneSol);
            oneSolCopy.add(i);
            if(dicCopy.get(i) == 1) dicCopy.remove(i);
            else dicCopy.put(i, dicCopy.get(i) - 1);
            dfs(result, dicCopy, oneSolCopy);
        }
    }
}
