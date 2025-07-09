package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Max_Area_Histogram {
    public static int largestReactangleArea(int[] heights) {
        int n = heights.length;
        int nsr[] = new int[n];
        int nsl[] = new int[n];
        int maxArea = 0;

        // next smaller right.
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // next smaller left.
        s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // current area :width=j-i-1 i.e nsr[i]-nsl[i]-1
        for(int i=0;i<n;i++){
            int width=nsr[i]-nsl[i]-1;
            int area=heights[i]*width;
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int result = largestReactangleArea(heights);
        System.out.println("Largest Rectangle Area: " + result);
    }

}
// area=height*width
// from each individual column we get our height i.e height of the column
// width is the will be the distance between next smaller left of column(i) and
// next smaller right of column(j) i.e width=j-i-1
// we can use next smaller element to find the next smaller left and right of
// each column