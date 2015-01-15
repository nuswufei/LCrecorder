public class Solution {
    class node {
        String str;
        int length;
        node(String s, int i) {
            str = s;
            length = i;
        }
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        HashSet<String> unvisited = new HashSet<String>(dict);
        unvisited.remove(start);
        LinkedList<node> queue = new LinkedList<node>();
        queue.add(new node(start, 1));
        while(queue.size() != 0) {
            node cur = queue.poll();
            List<String> visited = new ArrayList<String>();
            for(String s : unvisited) {
                if(isAdj(s, cur.str)) {
                    if(s.equals(end)) return cur.length + 1;
                    queue.add(new node(s, cur.length + 1));
                    visited.add(s);
                }
            }
            for(String s: visited) unvisited.remove(s);
        }
        return 0;
    }
    boolean isAdj(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); ++i) {
            if(s1.charAt(i) != s2.charAt(i)) ++count;
        }
        return count == 1;
    }
}
