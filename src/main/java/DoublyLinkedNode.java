public class DoublyLinkedNode{
    String key; // key is stored just for information, it is necessary for passing to hashmap
    Item item;
    DoublyLinkedNode next;
    DoublyLinkedNode prev;

    DoublyLinkedNode(String key, Item item){
        this.setItem(item);
        next = null;
        prev = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}