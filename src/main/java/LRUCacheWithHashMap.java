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
        //TODO put node to the back of the list
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
                moveToBack(newNode);
                count++;
            }else{
                DoublyLinkedNode removedNode = removeFromHead();
                hashMap.remove(removedNode.key);
                moveToBack(newNode);
            }
        }else{ // if already exists
            hashMap.update(key, node);
            moveToBack(node);
        }

    }

    public void moveToBack(DoublyLinkedNode node){

    }

    public DoublyLinkedNode removeFromHead(){
        return head;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
