# CopyOnWriteArrayList

`CopyOnWriteArrayList` is a thread-safe variant of `ArrayList` in Java. It is part of the `java.util.concurrent` package and is designed for use in concurrent environments where read operations are more frequent than write operations.

## Key Features
- **Thread-Safety**: Achieved by creating a new copy of the underlying array for every write operation (add, set, remove).
- **Read-Optimized**: Multiple threads can read from the list without requiring synchronization.
- **Snapshot Iterators**: Iterators operate on a snapshot of the list at the time they were created, so they do not throw `ConcurrentModificationException`.

## Use Cases
- Ideal for scenarios with frequent reads and infrequent writes.
- Suitable for applications where iterators need to be fail-safe.

## Example
```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Example {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Iterating over the list
        for (String item : list) {
            System.out.println(item);
        }

        // Modifying the list
        list.add("D");
        System.out.println("After modification: " + list);
    }
}
```

## Limitations
- Higher memory usage due to copying the array during write operations.
- Not suitable for scenarios with frequent writes.
