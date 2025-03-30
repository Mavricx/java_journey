package Java_DSA_Questions.Other_Problems;

public class Zigzag_Conversion {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();
        int currRow = 0;
        boolean isGoingDown = true;
        for (char c : s.toCharArray()) {
            sb[currRow] = sb[currRow].append(c);

            if (currRow == 0) {
                isGoingDown = true;
            } else if (currRow == numRows - 1) {
                isGoingDown = false;
            }

            currRow += isGoingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : sb)
            res.append(row);

        return res.toString();
    }

    public static void main(String[] args) {
        Zigzag_Conversion obj = new Zigzag_Conversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(obj.convert(s, numRows));
    }
}
