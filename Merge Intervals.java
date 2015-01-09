public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new intervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        for(Interval i : intervals) {
            if(result.size() == 0) result.add(i);
            else {
                Interval last = result.get(result.size() - 1);
                if(last.end >= i.start) last.end = Math.max(last.end, i.end);
                else result.add(i);
            }
        }
        return result;
    }
    class intervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {return i1.start - i2.start;}
    }
 }
