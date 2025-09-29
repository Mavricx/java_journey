package Java_DSA_Questions.Other_Problems;
import java.util.*;
public class Pascals_Triangle {
    public static List<List<Integer>> pascalTriangle(int numRows){
        List<List<Integer>> triangle=new ArrayList<>();
        for(int rowIdx=0;rowIdx<numRows;rowIdx++){

            List<Integer> row =new ArrayList<>();
            for(int i=0;i<=rowIdx;i++){
                row.add(1);
            }

            for(int j=1;j<rowIdx;j++){
                int val=triangle.get(rowIdx-1).get(j-1)
                        +triangle.get(rowIdx-1).get(j);

                row.set(j,val);
            }
            triangle.add(row);
        }
        return triangle;
    }
    public static void main(String[] args) {
        int numRows=5;
        List<List<Integer>> result=pascalTriangle(numRows);
        for(List<Integer> row:result){
            System.out.println(row);
        }
    }
}
