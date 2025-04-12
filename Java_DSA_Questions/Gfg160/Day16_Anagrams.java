package Java_DSA_Questions.Gfg160;

public class Day16_Anagrams {
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        int arr[]=new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            arr[s2.charAt(i)-'a']--;
        }
        
        for(int a: arr){
            if(a!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(areAnagrams(s1, s2)); // Output: true
        
        String s3 = "hello";
        String s4 = "world";
        System.out.println(areAnagrams(s3, s4)); // Output: false
    }
}