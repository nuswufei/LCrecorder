public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Map<Integer, List<String>> levels = new HashMap<Integer, List<String>>();
        int pathLength = getLength(start, end, dict, levels);
        List<List<String>> result = new ArrayList<List<String>>();
        if(pathLength < 1) return result;
        LinkedList<String> oneSol = new LinkedList<String>();
        oneSol.add(end);
        Set<String> path = new HashSet<String>();
        path.add(start);
        dfs(result, oneSol, pathLength - 1, levels, start);
        return result;
    }
    void dfs(List<List<String>> result, LinkedList<String> oneSol, int left, Map<Integer, List<String>> levels, String start) {
        if(left == 1) {
            oneSol.addFirst(start);
            result.add(oneSol);
            return;
        }
        List<String> curLevel = levels.get(left);
        String last = oneSol.getFirst();
        for(String s : curLevel) {
            if(isAdj(s, last)) {
                LinkedList<String> oneSolCopy = new LinkedList<String>(oneSol);
                oneSolCopy.addFirst(s);
                dfs(result, oneSolCopy, left - 1, levels, start);
            }
        }
    }
    boolean isAdj(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); ++i) {
            if(s1.charAt(i) != s2.charAt(i)) ++count;
        }
        return count == 1;
    }
    int getLength(String start, String end, Set<String> dict, Map<Integer, List<String>> levels) {
        LinkedList<String> queue = new LinkedList<String>();
        LinkedList<Integer> countQ = new LinkedList<Integer>();
        HashSet<String> dic = new HashSet<String>(dict);
        queue.add(start);
        countQ.add(1);
        dic.remove(start);
        while(queue.size() != 0) {
            int curCount = countQ.poll();
            String cur = queue.poll();
            if(levels.containsKey(curCount)) levels.get(curCount).add(cur);
            else {
                List<String> level = new ArrayList<String>();
                level.add(cur);
                levels.put(curCount, level);
            }
            if(cur.equals(end)) return curCount;
            for(String adj : getAdj(cur)) {
                if(dic.contains(adj)) {
                    queue.add(adj);
                    dic.remove(adj);
                    countQ.add(curCount + 1);
                }
            }
        }
        return -1;
    }
    List<String> getAdj(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); ++i) {
            char raw = s.charAt(i);
            for(char ch = 'a'; ch <= 'z'; ++ch) {
                if(ch != raw) sb.setCharAt(i, ch);
                result.add(sb.toString());
            }
            sb.setCharAt(i, raw);
        }
        return result;
    }
}
