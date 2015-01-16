public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int remain = gas[gas.length - 1] - cost[gas.length - 1];
        while(start > end) {
            if(remain >= 0) {
                remain += gas[end] -cost[end++];
            }
            else if(remain < 0) {
                --start;
                remain += gas[start] - cost[start];
            }
        }
        return remain >= 0 ? start : -1;
    }
}
