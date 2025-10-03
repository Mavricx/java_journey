package Java_DSA_Questions.Other_Leetcode_Problems;

public class Number_of_Islands {
    public static int numIslands(char[][] grid){
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1'){
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid,int r,int c ){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'){
            return;
        }
        if(grid[r][c]=='0') return ;

        grid[r][c]='0';

        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }

    public static void main(String[] args) {
        char[][] grid={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int result=numIslands(grid);
        System.out.println("Number of Islands: "+result);
    }
}
