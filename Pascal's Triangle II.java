public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastLevel = null;
        List<Integer> level = null;
        for(int i = 0; i <= rowIndex; ++i) {
            level = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j) {
                if(j == 0 || j == i) level.add(1);
                else level.add(lastLevel.get(j - 1) + lastLevel.get(j));
            }
            lastLevel = level;
        }
        return level;
    }
}
