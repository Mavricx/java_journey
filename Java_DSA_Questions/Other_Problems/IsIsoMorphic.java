package Java_DSA_Questions.Other_Problems;

import java.util.HashMap;

public class IsIsoMorphic {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        int arr1[]=new int[256];
        int arr2[]=new int[256];
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(arr1[ch1]!=arr2[ch2]){
                return false;
            }
            arr1[ch1]=i+1;
            arr2[ch2]=i+1;
        }
        return true;
    }
        public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Integer> mapS=new HashMap<>();
        HashMap<Character, Integer> mapT=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i),b=t.charAt(i);
            if(!mapS.containsKey(a)) mapS.put(a,i);
            if(!mapT.containsKey(b)) mapT.put(b,i);

            if(!(mapS.get(a).equals(mapT.get(b)))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="egg";
        String t="add";
        System.out.println(isIsomorphic(s, t));
    }
}