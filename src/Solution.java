import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */


    static public void main(String [] args){

        int [][] intGrid = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        boolean [][] grid = new boolean[intGrid.length][intGrid[0].length];
        for(int i = 0 ; i < intGrid.length; i++){
            for(int j = 0 ; j < intGrid[0].length; j++){
                if(intGrid[i][j] == 1){
                    grid[i][j] = true;
                }
                else {
                    grid[i][j] = false;
                }
            }

        }

        Solution s = new Solution();
        Point source = new Point(2,0);
        Point destination = new Point(2,2);
        System.out.println(s.shortestPath(grid,source,destination));

    }

    public int shortestPath(boolean[][] grid, Point source, Point destination) {

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        return findStep(grid,source,destination);

    }

    public int findStep(boolean[][] grid, Point source, Point destination){

        int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
        int step = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()){

            step++;
            int size = queue.size();

            for(int i = 0 ; i < size ; i++){

                Point point = queue.poll();

                for (int j = 0 ; j < 8 ; j++){
                    int x = point.x + deltaX[j];
                    int y = point.y + deltaY[j];
                    if(isBound(grid,x,y)){
                        continue;
                    }
                    if (x == destination.x && y == destination.y){
                        return step;
                    }
                    grid[x][y] = true;
                    queue.offer(new Point(x,y));
                }
            }
        }
        return -1;
    }


    public boolean isBound(boolean[][] grid, int x , int y){

        if ( x < 0 || x >= grid.length){
            return true;
        }
        if ( y < 0 || y >= grid[0].length){
            return true;
        }
        if(grid[x][y] == true){
            return true;
        }
        return false;
    }

}