public interface LRUCache{

    // Get the value (will always be positive) of the key if the key
    // exists in the cache, otherwise return -1.
    public Item get(String key);

    // Set or insert the value if the key is not already present.
    // When the cache reached its capacity, it should invalidate the least
    // recently used item before inserting a new item.
    public void set(String key,Item value);
}
