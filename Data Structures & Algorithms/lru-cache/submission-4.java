class DLL {
    int key, val;
    DLL prev, next;

    DLL (int aKey, int aVal) {
        key = aKey;
        val = aVal;
    }

    private void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }

    private void print() {
        if (prev == null) {
            System.out.print("[");
        } 
        
        if (next == null) {
            System.out.print("(" + key + ", " + val + ")");
            System.out.println("]");
        } else {
            System.out.print("(" + key + ", " + val + "), ");
            next.print();
        }
    }
}

class LRUCache {
    Map <Integer, DLL> map;
    DLL head, tail;
    int maxSize;

    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap();

        head = new DLL(0, 0);
        tail = new DLL(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLL node = map.get(key);

        if (node == null) {
            return -1;
        }

        node.remove();

        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;

        return node.val;
    }
    
    public void put(int key, int value) {
        DLL node = map.get(key);

        if (node != null) {
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            if (map.size() >= maxSize) {
                DLL lru = tail.prev;
                lru.remove();
                map.remove(lru.key);
            }

            node = new DLL(key, value);
        }

        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;

        map.put(key, node);

        head.print();
    }
}
