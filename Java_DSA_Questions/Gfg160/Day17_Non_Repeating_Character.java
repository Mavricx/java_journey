package Java_DSA_Questions.Gfg160;

public class Day17_Non_Repeating_Character {
    static char nonRepeatingChar(String s) {
        // code here
        int n=s.length();
        int arr[]=new int [26];
        for(int i=0;i<n;i++){
            arr[s.charAt(i) -'a']++;
        }
        for(int i=0;i<n;i++){
            if(arr[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return '$';
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(nonRepeatingChar(s)); // Output: 'f'
        
        String s2 = "aabbcc";
        System.out.println(nonRepeatingChar(s2)); // Output: '$'
    }
}
