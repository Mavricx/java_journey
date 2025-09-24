package Java_DSA_Questions.Other_Problems;

import java.util.*;
public class Group_Anagrams {
// Complexity Analysis
// Time Complexity:
// Sorting each string → O(K log K), where K = length of the string
// Doing this for N strings → O(N × K log K)
// Space Complexity: O(N × K) (for storing results in HashMap)
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs==null || strs.length==0) return new ArrayList<>();

        HashMap<String, List<String>> map=new HashMap<>();
        for(String s:strs){
            //sort the string to generate the key
            char[] charArray=s.toCharArray();
            Arrays.sort(charArray);
            String key=new String(charArray);
            
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams_counting(String[] strs){
        if(strs==null || strs.length==0) return new ArrayList<>();

        HashMap<String, List<String>> map=new HashMap<>();
        for(String s:strs){
            //count the frequency of each character
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
             StringBuilder sb=new StringBuilder();
             for(int num:count){
                sb.append('#');//to separate different character counts
                sb.append(num);
             }
            String key=sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);
    }
}
