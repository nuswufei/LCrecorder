public class LRUCache {
    class Node {
        Node pre;
        Node next;
        int val;
        int key;
        Node(int v, int k) {
            pre = null;
            next = null;
            val = v;
            key = k;
        }
    }
    private HashMap<Integer, Node> hm;
    private Node head;
    private int cap;
    private int size;
    private Node tail;
    public LRUCache(int capacity) {
        cap = capacity;
        hm = new HashMap<Integer, Node>();
        head = null;
        size = 0;
        tail = null;
    }
    private void moveToHead(Node node) {
        if(node == tail) tail = tail.pre;
        node.pre.next = node.next;
        if(node.next != null) node.next.pre = node.pre;
        node.pre = null;
        node.next = head;
        head.pre = node;
        head = node;
    }
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        else {
            Node node = hm.get(key);
            if(node != head) moveToHead(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        if(cap == 0) return;
        if(hm.containsKey(key)) {
            Node node = hm.get(key);
            node.val = value;
            if(node != head) moveToHead(node);
        }
        else if(size == 0) {
            Node node = new Node(value, key);
            head = node;
            tail = node;
            hm.put(key, node);
            ++size;
        }
        else {
            Node node = new Node(value, key);
            hm.put(key, node);
            head.pre = node;
            node.next = head;
            head = node;
            ++size;
            if(size > cap) {
                --size;
                hm.remove(tail.key);
                tail = tail.pre;
                tail.next = null;
            }
        }
    }
}
