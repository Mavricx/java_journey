package Java_DSA_Questions.Other_Leetcode_Problems;

public class Largest_Triangle {
 public static double largestTriangleArea(int[][] points) {
        int n=points.length;
        double maxArea=0.0;
        double area=0.0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    area=calculateArea(points[i],points[j],points[k]);
                    // 0.5*(Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)));
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    public static double calculateArea(int []p1, int[]p2,int[]p3){
        return 0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
    }
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
}
