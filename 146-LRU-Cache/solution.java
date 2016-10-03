public class LRUCache {
    public class ListNode {
        ListNode next;
        ListNode pre;
        public int key;
        public int val;
        public ListNode(){}
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    } 
    
    //use list and put the most recently used node to the head to get the least recently used node at the tail of the lis
    ListNode head, tail;
    
    //<key, ListNode> map
    Map<Integer, ListNode> map; 
    
    int capacity;
    int count;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        count = 0;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if(node == null)return -1;
        else {
            moveNodeToHead(node);
        }
        return node.val;
    }
    
    public void set(int key, int value) {
        
        ListNode node = map.get(key);
        if(node == null){
            node = new ListNode(key, value);
            addNode(node);
            if(count < capacity) {
                count++;
            }
            else {
                ListNode tailNode = removeTail();
                map.remove(tailNode.key);
            }
            map.put(key, node);
        }
        else {
            node.val = value;
            moveNodeToHead(node);
        }
    }
    
    public void removeNode(ListNode node) {
        if(map.containsKey(node.key)) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }
    }
    
    public void removeTail() {
         if(tail.pre != null) {
             ListNode node = tail.pre;
             tail.pre = tail.pre.pre;
             tail.pre.next = tail;
             return node;
         }
    }
    
    public void moveNodeToHead(ListNode node) {
        if(map.containsKey(node.key)) {
            addNode(node);
            removeNode(node);
        }
    }
    
    public void addNode(ListNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        // if(head == null) {
        //     head = node;
        //     tail = head;
        // }
        // else {
        //     head.pre = node;
        //     node.next = head;
        //     head = node;
        // }
    }
    
    
}