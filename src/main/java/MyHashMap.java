// Node implementation of the hashmap
// with separate chaining(or closed addressing)
public class MyHashMap {

    Node[] buckets;

    public class Node {
        private String key;
        private DoublyLinkedNode value;
        private Node next;

        Node(String key, DoublyLinkedNode value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    MyHashMap(){
        buckets = new Node[Constants.MAX_CACHE_SIZE];
    }

    public DoublyLinkedNode get(String key){
        Node curr = buckets[key.hashCode()];

        while(curr != null){
            if(key == curr.key)
                return curr.value;
            else curr = curr.next;
        }

        return null;
    }

    public void put(String key, DoublyLinkedNode value){
        Node curr = buckets[key.hashCode()];

        while(curr != null){
            if(key == curr.key) {
                curr.value = value;
            }else curr = curr.next;
        }
        // not found, insert
        curr = new Node(key, value);
        return;
    }

    public void remove(String key){
        Node curr = buckets[key.hashCode()];
        if(curr == null) return;

        while(curr != null){
            if(key == curr.key) {
                curr = null;
            }else curr = curr.next;
        }
        return;
    }

    public int hashCode(String s){
        return s.hashCode() % Constants.MAX_CACHE_SIZE;
    }
}
