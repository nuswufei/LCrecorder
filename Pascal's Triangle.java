public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 1; i <= numRows; ++i) {
            List<Integer> level = new ArrayList<Integer>();
            List<Integer> lastLevel = null;
            if(result.size() != 0) lastLevel = result.get(result.size() - 1);
            for(int j = 0; j < i; ++j) {
                if(j == 0 || j == i - 1) level.add(1);
                else level.add(lastLevel.get(j) + lastLevel.get(j - 1));
            }
            result.add(level);
        }
        return result;
    }
}
