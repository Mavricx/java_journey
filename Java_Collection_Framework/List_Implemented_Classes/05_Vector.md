
# Vectors

A `Vector` in Java is part of the `java.util` package and is one of the legacy classes that implements the `List` interface. Introduced in JDK 1.0, it is synchronized, making it thread-safe. Although now part of the collection framework, its synchronization overhead makes it less preferred compared to modern alternatives like `ArrayList` in single-threaded scenarios. However, `Vector` remains useful in multi-threaded environments where thread safety is required.

## Key Features of Vector

- **Dynamic Array**: Similar to `ArrayList`, `Vector` is a dynamic array that automatically grows when its capacity is exceeded.
- **Synchronized**: All methods in `Vector` are synchronized, ensuring thread safety. This can lead to performance overhead in single-threaded environments.
- **Legacy Class**: As a legacy class, `Vector` is generally replaced by `ArrayList` in single-threaded use cases for better performance.
- **Resizing Mechanism**: By default, `Vector` doubles its size when its capacity is exceeded, or grows by a specified increment if provided.
- **Random Access**: Like arrays and `ArrayList`, `Vector` supports efficient random access to elements using an index.

## Constructors of Vector

- `Vector()`: Creates a vector with an initial capacity of 10.
- `Vector(int initialCapacity)`: Creates a vector with a specified initial capacity.
- `Vector(int initialCapacity, int capacityIncrement)`: Creates a vector with an initial capacity and a specified capacity increment.
- `Vector(Collection<? extends E> c)`: Creates a vector containing the elements of the specified collection.

## Common Methods in Vector

- `add(E e)`: Adds an element to the end of the vector.
- `add(int index, E element)`: Inserts an element at the specified index.
- `get(int index)`: Retrieves the element at the specified index.
- `set(int index, E element)`: Replaces the element at the specified index.
- `remove(Object o)`: Removes the first occurrence of the specified element.
- `remove(int index)`: Removes the element at the specified index.
- `size()`: Returns the number of elements in the vector.
- `isEmpty()`: Checks if the vector is empty.
- `contains(Object o)`: Checks if the vector contains the specified element.
- `clear()`: Removes all elements from the vector.

## Internal Implementation of Vector

Internally, `Vector` uses an array to store its elements. When the array's capacity is exceeded, it doubles in size by default. This resizing operation is costly as it involves copying elements to the new array.

## Synchronization and Performance

Since `Vector` methods are synchronized, only one thread can access the vector at a time, ensuring thread safety. However, this synchronization introduces performance overhead in single-threaded environments due to the cost of locking and unlocking. 

In modern Java applications:
- Use `ArrayList` when synchronization is not required.
- Use `CopyOnWriteArrayList` or `ConcurrentHashMap` from the `java.util.concurrent` package for thread-safe collections.

