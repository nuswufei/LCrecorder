public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> segs = new HashMap<Integer, Integer>();
        for(int i : num) {
            segs.put(i, 1);
        }
        int max = 0;
        for(int i : num) {
            if(segs.containsKey(i)) {
                int low = i - 1;
                int high = i + 1;
                while(segs.containsKey(low)) {
                    segs.put(i, segs.get(i) + 1);
                    segs.remove(low--);
                }
                while(segs.containsKey(high)) {
                    segs.put(i, segs.get(i) + 1);
                    segs.remove(high++);
                }
                max = Math.max(high - low - 1, max);
            }
        }
        return max;
    }
}
