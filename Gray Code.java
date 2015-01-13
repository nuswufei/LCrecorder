public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; ++i) {
            int length = result.size() - 1;
            while(length >= 0 ) {
                result.add((int)Math.pow(2, i) + result.get(length--));
            }
        }
        return result;
    }
}
