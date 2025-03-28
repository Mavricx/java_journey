# Map
In Java, the `Map` interface is a part of the Java Collections Framework and is used to store data in key-value pairs. It provides a way to efficiently retrieve, update, and manage data based on unique keys. Below are some detailed insights into the `Map` interface and its commonly used implementation, `HashMap`.

## Overview of the `Map` Interface

A `Map` is a collection that associates keys to values. Each key is unique, and a key can map to only one value. The `Map` interface is not a subtype of the `Collection` interface, as it operates on key-value pairs rather than individual elements.

### Key Features of the `Map` Interface:
- **Key-Value Association**: Each entry in a `Map` consists of a key and a corresponding value.
- **Unique Keys**: Duplicate keys are not allowed. However, duplicate values are permitted.
- **Null Handling**: Some implementations allow null keys and null values (e.g., `HashMap` allows one null key and multiple null values).
- **Order Variations**:
    - `HashMap`: Does not guarantee any specific order.
    - `LinkedHashMap`: Maintains the insertion order of keys.
    - `TreeMap`: Maintains keys in their natural order or a custom comparator order.

### Commonly Used Methods:
- `put(K key, V value)`: Associates the specified value with the specified key.
- `get(Object key)`: Retrieves the value associated with the specified key.
- `remove(Object key)`: Removes the mapping for the specified key.
- `containsKey(Object key)`: Checks if the map contains the specified key.
- `containsValue(Object value)`: Checks if the map contains the specified value.
- `keySet()`: Returns a set of all keys in the map.
- `values()`: Returns a collection of all values in the map.
- `entrySet()`: Returns a set of all key-value pairs in the map.

---

## Detailed Characteristics of `HashMap`

`HashMap` is one of the most commonly used implementations of the `Map` interface. It is designed for quick lookups and efficient storage.

### Key Characteristics:
1. **Unordered**: `HashMap` does not maintain any specific order of its elements.
2. **Allows Nulls**: It permits one null key and multiple null values.
3. **Not Thread-Safe**: `HashMap` is not synchronized, meaning it is not safe for use in multi-threaded environments without external synchronization.
4. **Performance**: Provides constant-time performance (`O(1)`) for basic operations like `get` and `put`, assuming the hash function distributes elements evenly.

### Internal Structure:
In Java, the internal structure of a `HashMap` revolves around four key components: key, value, bucket, and hash function. These components work together to store and retrieve data efficiently.

### 1. Key
The key is a unique identifier used to associate with a specific value in the `HashMap`. Each key must implement the `hashCode()` and `equals()` methods to ensure proper functioning of the `HashMap`. Duplicate keys are not allowed, and any attempt to insert a duplicate key will overwrite the existing value.

### 2. Value
The value is the data associated with a specific key. Unlike keys, duplicate values are allowed in a `HashMap`. The value can be retrieved using its corresponding key.

### 3. Bucket
A bucket is a container that holds multiple key-value pairs. When a key-value pair is added to the `HashMap`, the hash code of the key determines the bucket where the pair will be stored. If multiple keys have the same hash code (hash collision), they are stored in the same bucket, typically as a linked list or a balanced tree (in case of high collision).

### 4. Hash Function
The hash function is used to compute the hash code of a key. This hash code determines the index of the bucket where the key-value pair will be stored. A good hash function minimizes collisions by distributing keys uniformly across buckets, ensuring efficient retrieval and storage.

These components collectively enable the `HashMap` to provide fast and efficient operations for storing and retrieving data.

---

## How Data is Stored in the `HashMap`

### Step 1: Hashing the Key
The key is passed through a hash function to generate a unique hash code (an integer number). This hash code helps determine where the key-value pair will be stored in the array (called a "bucket array").

### Step 2: Calculating the Index
The hash code is used to calculate an index in the array (bucket location) using:
```java
int index = hashCode % arraySize;
```
The index decides which bucket will hold this key-value pair. For example, if the array size is 16, the key's hash code will be divided by 16, and the remainder will be the index.

### Step 3: Storing in the Bucket
The key-value pair is stored in the bucket at the calculated index. Each bucket can hold multiple key-value pairs (this is called a collision handling mechanism, discussed later).

---

## How `HashMap` Retrieves Data

When we call `get(key)`, the `HashMap` follows these steps:

1. **Hashing the Key**: Similar to insertion, the key is hashed using the same hash function to calculate its hash code.
2. **Finding the Index**: The hash code is used to find the index of the bucket where the key-value pair is stored.
3. **Searching in the Bucket**: Once the correct bucket is found, it checks for the key in that bucket. If it finds the key, it returns the associated value.

---

## Handling Collisions

Since different keys can generate the same index (called a collision), `HashMap` uses a technique to handle this situation. Java's `HashMap` uses linked lists (or balanced trees after Java 8) for this.

If multiple key-value pairs map to the same bucket, they are stored in a linked list inside the bucket. When a key-value pair is retrieved, the `HashMap` traverses the linked list, checking each key until it finds a match.

Example:
```java
map.put("apple", 50);
map.put("banana", 30);
map.put("orange", 80);
```
Let's say "apple" and "orange" end up in the same bucket due to a hash collision. They will be stored in a linked list in that bucket:
```
Bucket 5: ("apple", 50) -> ("orange", 80)
```
When we do `map.get("orange")`, `HashMap` will go to Bucket 5 and then traverse the linked list to find the entry with the key "orange".

---

## HashMap Resizing (Rehashing)

`HashMap` has an internal array size, which by default is 16. When the number of elements (key-value pairs) grows and exceeds a certain load factor (default is 0.75), `HashMap` automatically resizes the array to hold more data. This process is called rehashing.

### During Rehashing:
1. The array size is doubled.
2. All existing entries are rehashed (i.e., their positions are recalculated) and placed into the new array.

This ensures the `HashMap` continues to perform efficiently even as more data is added.
