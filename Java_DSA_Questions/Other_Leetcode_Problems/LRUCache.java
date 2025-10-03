package Java_DSA_Questions.Other_Leetcode_Problems;
import java.util.*;
public class LRUCache {
     class Node{
        int key,value;
        Node prev,next;
        Node(int k,int v){
            key=k; 
            value=v;
        }
    }
    private int capacity;
    private Map<Integer,Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        // Dummy head & tail to avoid null checks
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node=map.get(key);
            node.value=value;
            moveToHead(node);
        }
        else{
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            addNode(newNode);

            if(map.size()> capacity){
                Node lru=popTail();
                map.remove(lru.key);
            }
        }
    }
   
   // Helpers
    private void addNode(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    private void removeNode(Node node){
        Node p=node.prev,n=node.next;
        p.next=n;
        n.prev=p;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }
    private Node popTail(){
        Node res=tail.prev;
        removeNode(res);
        return res;
    }
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1); // cache is {1=1}
        lruCache.put(2,2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));    // return 1
        lruCache.put(3,3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4,4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1));    // return -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4
    }
}
