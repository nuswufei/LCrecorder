public class Solution {
    public List<List<String>> partition(String s) {
        Boolean[][] dpt = new Boolean[s.length()][s.length()];
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>();
        dfs(s, 0, result, sol, dpt);
        return result;
    }
    void dfs(String s, int index, List<List<String>> result, List<String> sol, Boolean[][] dpt) {
        if(index == s.length()) {
            result.add(sol);
            return;
        }
        for(int i = index; i < s.length(); ++i) {
            if(isP(s, index, i, dpt)) {
                List<String> solCopy = new ArrayList<String>(sol);
                solCopy.add(s.substring(index, i + 1));
                dfs(s, i + 1, result, solCopy, dpt);
            }
        }
    }
    boolean isP(String s, int start, int end, Boolean[][] dpt) {
        if(start > end) return true;
        if(dpt[start][end] != null) return dpt[start][end];
        if(s.charAt(start) != s.charAt(end)) {
            dpt[start][end] = false;
            return false;
        }
        dpt[start][end] = isP(s, start + 1, end - 1, dpt);
        return dpt[start][end];
    }
}
