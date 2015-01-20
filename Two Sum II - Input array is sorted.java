public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        result[1] = numbers.length - 1;
        while(result[0] < result[1]) {
            int cur = numbers[result[0]] + numbers[result[1]];
            if(cur == target) break;
            if(cur  < target) ++result[0];
            else --result[1];
        }
        ++result[0];
        ++result[1];
        return result;
    }
}
