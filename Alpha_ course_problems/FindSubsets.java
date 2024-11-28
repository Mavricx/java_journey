public class FindSubsets {

    public static void findSubset(String str, String ans, int i) {
        if (i == str.length()) { //as long as i is not 
            if (ans.length() == 0) {
                System.out.println("null");//for null case
            } else {
                System.out.println(ans);
            }

            return;//return for one case
        }
        findSubset(str, ans + str.charAt(i), i + 1); //char goes in
        findSubset(str, ans, i + 1);//char does not go in
    }

    public static void main(String[] args) {
        findSubset("abc", "", 0);
    }
}
