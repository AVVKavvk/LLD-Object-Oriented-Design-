# In-Memory Cache System

## Description

Vipin Bhaiya got a new client for his web-services company. The client wants to have an efficiently designed In-Memory Cache system, which he/she can invoke with the driver class. Help Babbar Bhaiya to deliver this task.

## Requirements

- Create a user-defined size cache with an eviction policy as **"LRU"** (Least Recently Used).
- Support the following functionalities in the system:
  - Fetch
  - Insert
  - Delete
  - Clear

## Implementation Details

### LRU Cache

The LRU (Least Recently Used) cache is a type of cache mechanism that evicts the least recently used items first. This is useful in scenarios where the cache has limited space and you need to manage which items to keep based on their usage.

### Features

- **User-Defined Size**: The cache should be initialized with a user-defined size.
- **Eviction Policy**: Implement the LRU eviction policy to ensure efficient cache management.
- **Functionalities**:
  - **Fetch**: Retrieve an item from the cache.
  - **Insert**: Add an item to the cache.
  - **Delete**: Remove an item from the cache.
  - **Clear**: Clear all items from the cache.

## Example Usage

Below is an example of how the cache system might be used in a driver class:

```java
public class Main {
    public static void main(String[] args) {
        
        cacheService cache= cacheService.getInstance();
        // Initialize the cache with a size of 10
        cache.init(10,Policy.LRU.toString());
 

//        cache.delete(3);
        cache.clear();
        cache.delete(2);
        System.out.println(cache.get(2));

        // Insert items into the cache
        cache.put(1, "Item1");
        cache.put(2, "Item2");
        cache.put(3, "Item3");

        // Fetch an item from the cache
        System.out.println(cache.get(1)); // Output: Item1

        // Insert another item, causing the least recently used item to be evicted
        cache.put(4, "Item4");

        // Try to fetch the evicted item
        System.out.println(cache.get(2)); // Output: null (since item 2 was evicted)

        // Delete an item
        cache.remove(3);

        // Clear the cache
        cache.clear();
    }
}
