# List Interface

The `List` interface in Java is part of the `java.util` package and extends the `Collection` interface. It represents an ordered collection (also known as a sequence) that allows precise control over where elements are inserted. Lists can contain duplicate elements.

The `List` interface is implemented by several classes in the Java Collection Framework, including `ArrayList`, `LinkedList`, `Vector`, and `Stack`.

## Key Features of the List Interface

- **Order Preservation**: Elements are maintained in the order they are inserted.
- **Index-Based Access**: Elements can be accessed and modified using their index.
- **Allows Duplicates**: Duplicate elements are permitted in the list.

---

# ArrayList

An `ArrayList` is a resizable array implementation of the `List` interface. Unlike arrays in Java, which have a fixed size, an `ArrayList` can change its size dynamically as elements are added or removed. This flexibility makes it a popular choice when the number of elements in a list isn't known in advance.

### Internal Working

- Unlike a regular array, which has a fixed size, an `ArrayList` can grow and shrink as elements are added or removed.
- This dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array.
- Internally, the `ArrayList` is implemented as an array of `Object` references. When you add elements to an `ArrayList`, you're essentially storing these elements in this internal array.
- When you create an `ArrayList`, it has an initial capacity (default is 10). The capacity refers to the size of the internal array that can hold elements before needing to resize.

### Difference Between Capacity and Size

- **Capacity**: The number of elements the `ArrayList` can hold before resizing.
- **Size**: The number of elements currently stored in the `ArrayList`.

## Adding Elements

When adding an element to an `ArrayList`, the following steps occur:

1. **Check Capacity**: Before adding the new element, the `ArrayList` checks if there is enough space in the internal array (`elementData`). If the array is full, it needs to be resized.
2. **Resize if Necessary**: If the internal array is full, the `ArrayList` will create a new array with a larger capacity (usually 1.5 times the current capacity) and copy the elements from the old array to the new array.
3. **Add the Element**: The new element is then added to the internal array at the appropriate index, and the size is incremented.

## Resizing the Array

- **Initial Capacity**: By default, the initial capacity is 10. This means the internal array can hold 10 elements before it needs to grow.
- **Growth Factor**: When the internal array is full, a new array is created with a size 1.5 times the old array. This growth factor balances memory efficiency and resizing cost.
- **Copying Elements**: When resizing occurs, all elements from the old array are copied to the new array, which is an O(n) operation, where `n` is the number of elements in the `ArrayList`.

## Removing Elements

1. **Check Bounds**: The `ArrayList` first checks if the index is within the valid range.
2. **Remove the Element**: The element is removed, and all elements to the right of the removed element are shifted one position to the left to fill the gap.
3. **Reduce Size**: The size is decremented by 1.

## Shrinking the ArrayList Size

The capacity does not decrease automatically after resizing to a greater size, even if many elements are removed. To shrink the array or trim it, use:

```java
arrayList.trimToSize();
```

## Different Ways to Create an ArrayList

```java
// 1st way
List<String> list = new ArrayList<>();
System.out.println(list.getClass().getName()); // java.util.ArrayList

// 2nd way
List<String> list1 = Arrays.asList("Monday", "Tuesday"); // Fixed-size list
System.out.println(list1.getClass().getName()); // java.util.Array$ArrayList
list1.add("Saturday"); // Error: UnsupportedOperationException
list1.set(1, "Monday"); // Allowed: Replacing elements

// 3rd way
String[] array = {"Apple", "Banana", "Cherry"};
List<String> list2 = Arrays.asList(array);
System.out.println(list2.getClass().getName()); // java.util.Array$ArrayList
// To make list2 modifiable:
List<String> list4 = new ArrayList<>(list2);

// 4th way
List<Integer> list3 = List.of(1, 2, 3); // Immutable list
```

## `addAll()` Method

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
List<Integer> list2 = List.of(4, 5, 6, 7);

list.addAll(list2);
System.out.println(list); // [1, 2, 3, 4, 5, 6, 7]

// To remove an element by value:
list.remove(Integer.valueOf(3));
```

## Removing an Element by Value

```java
List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");
fruits.add("Banana");

fruits.remove("Apple"); // Removes the first occurrence of "Apple"
```

## Time Complexity

- **Access**: O(1)
- **Add (Worst Case - Resizing)**: O(n)
- **Remove (Involves Shifting)**: O(n)
- **Iteration**: O(n)

## Use Cases of List Implemented Classes

### 1. ArrayList

- **Dynamic Resizing**: Suitable for scenarios where the size of the list is not fixed and frequent additions/removals occur at the end.
- **Random Access**: Ideal for applications requiring fast access to elements using an index.
- **Read-Heavy Operations**: Best for use cases where read operations are more frequent than write operations.

### 2. LinkedList

- **Frequent Insertions/Deletions**: Preferred when there are frequent insertions or deletions in the middle of the list.
- **Queue/Deque Implementations**: Useful for implementing data structures like queues and deques due to its efficient `addFirst()` and `addLast()` methods.
- **Memory Efficiency**: Suitable when memory overhead due to resizing (as in `ArrayList`) is a concern.

### 3. Stack

- **LIFO Operations**: Used in scenarios requiring Last-In-First-Out (LIFO) operations, such as undo functionality, expression evaluation, or backtracking algorithms.
- **Thread Safety**: Provides thread-safe operations for stack-based use cases.

### 4. Vector

- **Thread-Safe Operations**: Suitable for legacy applications requiring thread-safe operations on lists.
- **Synchronized Access**: Useful in multi-threaded environments where synchronized access to the list is necessary.
- **Legacy Code**: Often used in older Java applications for backward compatibility.

### 5. CopyOnWriteArrayList

- **Read-Mostly Scenarios**: Ideal for use cases where read operations are significantly more frequent than write operations.
- **Thread-Safe Iteration**: Ensures safe iteration in multi-threaded environments without requiring external synchronization.
- **Immutable Snapshots**: Useful when a consistent snapshot of the list is needed during iteration, even if the list is being modified concurrently.
- **Event Listeners**: Commonly used in scenarios like maintaining a list of event listeners where modifications are infrequent but iteration is frequent.

```java
Collection.sort(arraylist1,Collections.reverseOrder());
```