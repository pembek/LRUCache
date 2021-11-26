import java.util.HashMap;
import java.util.Iterator;

public class LRUCacheWithHashMap implements LRUCache, Iterable{

    private MyHashMap hashMap;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int capacity, count;

    public LRUCacheWithHashMap(int capacity){
        this.capacity = capacity;
        count = 0;
        head = null;
        tail = null;
        hashMap = new MyHashMap();
    }

    @Override
    public Item get(String key) {
        DoublyLinkedNode node = hashMap.get(key);
        // put node to the back of the list
        // remove node
        node.next.prev = node.prev;
        node.prev.next = node.next;
        // add to tail
        node.next = null;
        node.prev = tail;
        tail.next = node;
        tail = node;

        return node.getItem();
    }

    @Override
    public void set(String key, Item value) {
        // Set connections of the Node pointers for the double linked list
        // And add the hashmap

        //check hashmap
        DoublyLinkedNode node = hashMap.get(key);

        if(node != null){  // if it doesn't exists in hashmap
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            hashMap.put(key,newNode);
            if(count < capacity){
                //move to back
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
                count++;
            }else{
                // remove from head
                head.next.prev = null;
                head = head.next;
                //move to back
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
        }else{ // if already exists
            hashMap.put(key, node);
            //move to back
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
