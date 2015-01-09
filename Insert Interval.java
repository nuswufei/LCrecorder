public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        int left = 0;
        int right = intervals.size();
        int target = 0;
        while(left <= right) {
            int mid = (left + right) >> 1;
            int compareResult = isTarget(mid, intervals, newInterval);
            if(compareResult == 0) {
                target = mid;
                break;
            }
            if(compareResult > 0) left = mid + 1;
            else right = mid - 1;
        }
        intervals.add(target, newInterval);
        target = Math.max(target - 1, 0);
        for(int i = target; i < intervals.size() - 1; ) {
            if(intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                intervals.remove(i + 1);
            }
            else if (i > target) break;
            else ++i;
        }
        return intervals;
    }
    int isTarget(int i, List<Interval> intervals, Interval newInterval) {
        if(i == 0) return intervals.get(0).start >= newInterval.start ? 0 : 1;
        if(i == intervals.size()) return newInterval.start >= intervals.get(i - 1).start ? 0 : -1;
        if(newInterval.start > intervals.get(i - 1).start && newInterval.start <= intervals.get(i).start) return 0;
        if(newInterval.start <= intervals.get(i - 1).start) return -1;
        else return 1;
    }
 }
