public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> numHM = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; ++i) {
            if(numHM.containsKey(target - numbers[i])) {
                return new int[] {numHM.get(target - numbers[i]) + 1, i + 1};
            } 
            else {
                numHM.put(numbers[i], i);
            }
        }
        return new int[] {-1, -1};
    }
} 
