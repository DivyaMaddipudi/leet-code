class MyHashMap {
    
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
   
    
    Node[] nodes;
    int bucket;
    
    public MyHashMap() {
        bucket = 1000;
        nodes = new Node[bucket];
    }
    
     public int getBucket(int key) {
        return key%bucket;
    }
    
    public Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        
        while(curr != null && curr.key!=key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = getBucket(key);
        if(nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        } 
        
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index] == null) {
            return -1;
        }
        
        Node prev = find(nodes[index], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index] == null) {
            return;
        }
        
        Node prev = find(nodes[index], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */