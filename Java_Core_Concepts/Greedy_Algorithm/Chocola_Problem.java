package Java_Core_Concepts.Greedy_Algorithm;

// Q.We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate
// into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive
// integer. This cost does not depend on the size of the part that is being broken but only depends on
// the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines
// with xl, x2, ..., xm-l and along horizontal lines with YI, Y2,....yn-l.
// Compute the minimal cost of breaking the whole chocolate into single squares.

//deductions
//1.we have make all the cuts available but we can choose the order of cuts to minimize the total cost of the cuts.
//2.The number of pieces of chocolate increases after each cut.
//3.we have to make expensive cuts first and then later the cheaper cuts to minimize the cost.
//4.cost of vertical cuts =horizontal pieces * cost of vertical cut.
//5.cost of horizontal cuts =vertical pieces * cost of horizontal cut.
import java.util.*;

public class Chocola_Problem {

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };// m-1
        Integer costHor[] = { 4, 1, 2 };// n-1
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int totalCost = 0;
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        while (h < costHor.length && v < costVer.length) {
            // case:vertical cost< horizontal cost
            if (costVer[v] <= costHor[h]) {// take horizontal cut.(expensive cut first)
                totalCost += (costHor[h] * vp);
                hp++;
                h++;
            } else {// vertical cut take place
                totalCost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costHor.length) {
            totalCost += (costHor[h] * vp);
            h++;
            hp++;
        }
        while (v < costVer.length) {
            totalCost += (costVer[v] * hp);
            v++;
            vp++;
        }
        System.out.println("Total cost of breaking the chocolate is: " + totalCost);
    }
}
