# String Declaration

```java
String str = "abcd";
String str2 = new String("xyz");
```

Java strings are immutable, which means modifying one string results in creating a new string altogether.

## String Length

```java
int len = str.length();
```

## String Concatenation

```java
String firstName = "pikul";
String lastName = "pattanayak";
String fullName = firstName + " " + lastName;
```

## charAt() Function

To get the character at a certain position, we use the `.charAt` function.

```java
char charAtPosition = str.charAt(2);
```

## String Comparison

```java
String str1 = "tony";
String str2 = "tony";
String str3 = new String("tony");

if (str1 == str2) {
    // returns true as they point towards the same string since they hold the same value
}

if (str1 == str3) {
    // returns false as 'new' creates a new string and str1 and str3 point towards different strings
}

// To compare the values of different strings, we use the .equals() function.

if (str1.equals(str3)) {
    // returns true as the values of str1 and str3 are the same
}
```

## Substring Function

```java
String str = "hello world";
String firstWord = str.substring(0, 5); // The character at the starting index is included in the substring, and the character at the ending index is not included.
```

# compareTo functions

"apple"< "banana" --> comparison occurs as lexicographic order.

```java
str1.compareTo(str2);
//will return
//--> 0: if both are equal
//--> less than 0: if str1 <str2
//--> greater than 0: if str1>str2
```

# compareToIgnoreCase()

this compares strings ignoring if the char is in uppercase or in lowercase

# String Builder

> when we running through a loop and modifying string again and again the time complexity increases dramatically as each time modifying will create a new string and copying te earlier value have a time complexity of n (length of the string) and if the loop is running m times then the time complexity will be O(n\*m) which is high.
> To solve this issue we have to we use StringBuilder

```java
StringBuilder sb=new StringBuilder("this is a string ");
//to get this in the string format
sb.toString();
Integer a=10;
a.toString()//-->"10"
//when int a=10;
a.toString();//-->error
```
# Different functions of StringBuilder
```java
public class StrBuilderClass {
  
    public static void main(String[] args) {

        // Create a new StringBuilder with the
        StringBuilder sb = new StringBuilder("GeeksforGeeks");
        System.out.println("Initial StringBuilder: " + sb);

        // 1. Append a string to the StringBuilder
        sb.append(" is awesome!");
        System.out.println("After append: " + sb);

        // 2. Insert a substring at a specific position
        sb.insert(13, " Java");
        System.out.println("After insert: " + sb);

        // 3. Replace a substring with another string
        sb.replace(0, 5, "Welcome to");
        System.out.println("After replace: " + sb);

        // 4. Delete a substring from the StringBuilder
        sb.delete(8, 14);
        System.out.println("After delete: " + sb);

        // 5. Reverse the content of the StringBuilder
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // 6. Get the current capacity of the StringBuilder
        int capacity = sb.capacity();
        System.out.println("Current capacity: " + capacity);

        // 7. Get the length of the StringBuilder
        int length = sb.length();
        System.out.println("Current length: " + length);

        // 8. Access a character at a specific index
        char charAt5 = sb.charAt(5);
        System.out.println("Character at index 5: " + charAt5);

        // 9. Set a character at a specific index
        sb.setCharAt(5, 'X');
        System.out.println("After setCharAt: " + sb);

        // 10. Get a substring from the StringBuilder
        String substring = sb.substring(5, 10);
        System.out.println("Substring (5 to 10): " + substring);

        // 11. Find the index of a specific substring
        sb.reverse(); // Reversing back to original order for search
        int indexOfGeeks = sb.indexOf("Geeks");
        System.out.println("Index of 'Geeks': " + indexOfGeeks);

        // 12. Delete a character at a specific index
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb);

        // 13. Convert the StringBuilder to a String
        String result = sb.toString();
        System.out.println("Final String: " + result);
    }
}
```