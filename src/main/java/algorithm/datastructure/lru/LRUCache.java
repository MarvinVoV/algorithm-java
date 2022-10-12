package algorithm.datastructure.lru;

import java.util.HashMap;

/**
 * {@index LRU Cache implemented by double linked list}
 *
 * @author hufeng
 * @version LRUCache.java, v 0.1 2021/2/17 09:22 Exp $
 * @see <a href="https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/"/>
 */

public class LRUCache {
    static class Node {
        int  key;
        int  value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int                    capacity;
    private int                    count;
    private Node                   head, tail;

    private LRUCache() {
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            System.out.println("Key " + key + " not found.");
            return -1;
        }
        Node node = map.get(key);
        int result = node.value;
        deleteNode(node);
        addToHead(node);
        System.out.println("Got the value: " + result + " for the key: " + key);
        return result;
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
            addToHead(node);
        }
    }


}
