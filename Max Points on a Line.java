public class Solution {
    public int maxPoints(Point[] points) {
        HashMap<List<Double>, HashSet<Integer>> seg = new HashMap<List<Double>, HashSet<Integer>>();
        int lineCount = 0;
        for(int i = 0; i < points.length; ++i) {
            for(int j = i; j < points.length; ++j) {
                Point p1 = points[i];
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y) continue;
                List<Double> key = new ArrayList<Double>();
                if(p1.x == p2.x) {
                    key.add(Double.NaN);
                    key.add((double)p1.x);
                }
                else {
                    key.add(((double)p1.y - p2.y) / (p1.x - p2.x));
                    key.add(0 + ((double)p2.x * p1.y - p1.x * p2.y) / (p2.x - p1.x));
                }
                if(!seg.containsKey(key)) {
                    seg.put(key, new HashSet<Integer>());
                    ++lineCount;
                }
                seg.get(key).add(i);
                seg.get(key).add(j);
            }
        }
        if(lineCount < 2) return points.length;
        int max = 2;
        for(List<Double> key : seg.keySet()) {
            max = Math.max(max, seg.get(key).size());
        }
        return max;
    }
}
