public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] indicator = new int[S.length];
        while(true) {
            result.add(getList(S, indicator));
            int carry = 1;
            for(int i = 0; i < S.length; ++i) {
                int digit = carry + indicator[i];
                indicator[i] = digit % 2;
                carry = digit / 2;
            }
            if(carry == 1) return result;
        }
    }
    private List<Integer> getList(int[] S, int[] indicator) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < S.length; ++i) {
            if(indicator[i] == 1) result.add(S[i]);
        }
        return result;
    }
}
