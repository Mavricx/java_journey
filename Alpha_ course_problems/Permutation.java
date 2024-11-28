public class Permutation {
    public static void findPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans+"  ");
            return;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
                String newStr = str.substring(0, i) + str.substring(i + 1);
                findPermutation(newStr, ans + curr);
            }
        }
    }

    public static void main(String[] args) {
        String str = "faoda";
        findPermutation(str, "");
    }
}
// time Complexity :O(n*n!)
