public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; ++i) nums.add(i);
        int factor = 1;
        for(int i = 1; i <= n - 1; ++i) factor *= i;
        for(int i = 1; i <= n; ++i) {
            result.append(nums.get((k - 1) / factor) + "");
            nums.remove((k - 1) / factor);
            k = (k - 1) % factor + 1;
            if(i != n) factor /= n - i;
        }
        return result.toString();
    }
}
