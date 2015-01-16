public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        HashMap<Integer, UndirectedGraphNode> dic = new HashMap<Integer, UndirectedGraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(node.label);
        while(queue.size() != 0) {
            UndirectedGraphNode cur = queue.pop();
            if(!dic.containsKey(cur.label)) dic.put(cur.label, new UndirectedGraphNode(cur.label));
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                if(!dic.containsKey(neighbor.label)) dic.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                dic.get(cur.label).neighbors.add(dic.get(neighbor.label));
                if(!visited.contains(neighbor.label)) {
                    visited.add(neighbor.label);
                    queue.add(neighbor);
                }
            }
        }
        return dic.get(node.label);
    }
}
