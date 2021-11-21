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
        DoublyLinkedNode<Item> doublyLinkedNode = new DoublyLinkedNode<Item>(new Item());
        // TODO if not exists return null
        return doublyLinkedNode;
    }

    public void put(String key, DoublyLinkedNode value){

    }

    public void update(String key, DoublyLinkedNode value){

    }

    public void remove(String key){

    }

    public int hashCode(String s){
        return s.hashCode() % Constants.MAX_CACHE_SIZE;
    }
}
