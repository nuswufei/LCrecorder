public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comp = new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1, comp);
        if(k > nums.length || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; ++i) {
            pq.add(nums[i]);
        }
        res[0] = pq.peek();
        for(int i = k; i < nums.length; ++i) {
            pq.add(nums[i]);
            pq.remove(nums[i - k]);
            res[i - k + 1] = pq.peek();
        }
        return res;
    }
}
