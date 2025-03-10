package Strings;

public class StringCompression {
    public static String compress(String str) {// time complexity O(n)
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {// loop runs if the char repeats
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if (count > 1) {// if the char repeats more than once then add number
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static String compressWithStringBuffer(String str) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compressWithStringBuffer(str)); // a2bc5a3
    }
}