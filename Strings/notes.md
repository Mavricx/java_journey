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