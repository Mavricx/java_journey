# Trie

> This is a tree type data structure, also called prefix tree / retrieval tree / digital search tree.

## What is a Trie?

A **Trie** is a special type of tree used to store associative data structures, typically strings. Each node in a Trie represents a character of a string, and the path from the root to a node represents a prefix of the stored strings.

## Structure of a Trie

- Each node contains:
  - An array or map of child nodes (one for each possible character).
  - A boolean flag to indicate if the node marks the end of a valid word (often called `isEndOfWord`).

## How a Trie is Formed for Strings

1. **Insertion:**
   - Start at the root node.
   - For each character in the string:
     - Check if a child node exists for the character.
     - If not, create a new node for that character.
     - Move to the child node.
   - After the last character, mark the current node as the end of a word.

2. **Example:**
   - Insert the words: `["cat", "car", "dog"]`
   - The Trie will look like:
    (root)
     /    \
    c      d
   /        \
  a          o
 / \          \
t   r          g
   - Here, nodes for 't', 'r', and 'g' are marked as end of words.

   for words[]="the","a","there","their","any","thee"

  (root)
  /    \
 a      t
 |      |
 n      h
 |      |
 y*     e*
      / | \
    e*  i  r
        |   |
        r*  e*

3. **Searching:**
   - Start at the root and follow the path for each character in the string.
   - If you reach the end of the string and the node is marked as end of word, the string exists in the Trie.

## Advantages

- Efficient for prefix-based searches (e.g., autocomplete).
- Fast insertion and search operations (O(L), where L is the length of the word).

## Use Cases

- Dictionary word lookups
- Autocomplete systems
- Spell checkers
- IP routing (longest prefix)