public class GridWays {
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {// base case // reached point where it needs to reach
            return 1;
        } else if (i == n || j == m) {// got outside the box / boundry
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m); // for going right
        int w2 = gridWays(i, j + 1, n, m);// for going down
        return w1 + w2;

    }

    public static void main(String[] args) {
        int n = 3;// no of rows in the box
        int m = 3;// no of columNs in the box
        System.out.println("The no of ways one can reach the destination is : " + gridWays(0, 0, n, m));
    }
}
// ========//
// we can reduce this problem into permutation problem as we need (n-1)*down
// and (m-1)*right turns to get into the destination
// string consist of n-1 ds and m-1 rs so the number of ways this can be
// arranged is (n-1+m-1)!/(n-1)!(m-1)! which is total no of ways it can be
// solved
// Time Complexity: O(n+m)and this is the linear time complexity rather than
// 2^(n+m)
// time complexity