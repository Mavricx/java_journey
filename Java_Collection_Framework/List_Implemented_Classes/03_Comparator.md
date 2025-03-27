# Comparator

In Java, the `Comparator` interface is used to define a custom ordering for objects. It is part of the `java.util` package and is typically used when you need to sort objects in a way that is different from their natural ordering (defined by the `Comparable` interface).

## Key Features
- It provides a way to define multiple sorting sequences.
- The `compare(T o1, T o2)` method is used to compare two objects of same type..
- It can be implemented as a lambda expression or an anonymous class.

## Example
```java
import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(3, "Alice"),
            new Student(1, "Bob"),
            new Student(2, "Charlie")
        );

        // Sort by ID
        students.sort(Comparator.comparingInt(student -> student.id));
        System.out.println("Sorted by ID: " + students);

        // Sort by Name
        students.sort(Comparator.comparing(student -> student.name));
        System.out.println("Sorted by Name: " + students);
    }
}
```

## Advantages
- Allows custom sorting logic.
- Can be used to sort objects based on multiple attributes.

## When to Use
Use `Comparator` when:
- You need to sort objects in a way that differs from their natural order.
- You want to define multiple sorting criteria for the same type of objects.
- You need flexibility in sorting logic.
