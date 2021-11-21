public class DoublyLinkedNode{
    String key; // key is stored just for information, it is necessary for passing to hashmap
    Item item;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;

    DoublyLinkedNode(String key, Item item){
        this.setItem(item);
        head = null;
        tail = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}